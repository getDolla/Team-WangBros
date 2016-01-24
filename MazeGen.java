public class MazeGen{
    //instance variables
    public int r, c;
    public Object[][] maze;

    public MazeGen( int x, int y ) {
    if( (x>1) || (x<43) ) {
        r = 2*x+1; // initializes row number
    }

    else {
        r = 7;
    }

    if( (y>1) || (y>43) ) {
        c = 2*y+1; // initializes column number
    }

    else {
        c = 7;
    }

    maze = new Object[r][c];
    //generate( maze );
    }

    private static int extendRow( Object[][] array , int n ) { // should only be called starting at row 3
	
	int high = 0; 
	for ( int c = 1; c < array[n].length - 1; c += 2 ) {
	    if ( (Integer) array[n][c] > high ) {
		high = (Integer) array[n][c]; // finds highest value so that assigning numbers will be easier
	    }
	}

	int groups = 1; // keeps the number of groups for extension
	for ( int c = 3; c < array[n].length - 1; c += 2 ) {
	    if (((Integer) array[n][c]) != ((Integer)array[n][c - 2])) {
		groups ++;
	    }
	}


	int end = 1; // keeps track of the last cell that is checked in each grouping
	for ( int c = 0 ; c < groups; c ++ ) {
	    

	    int number = 1; // checks number of times a number appears so that at least one cell is guaranteed to extend
	    int q; // for later use (right cells)
	    for ( q = end + 2; q < array[0].length - 1; q += 2 ) {
		if (((Comparable)array[n][q]).compareTo((Comparable)array[n][q - 2]) != 0 ) {
		    end = q;
		    break; // breaks when first occurence of inequality
		} 
		else {
		    end += 2;
		    number++;
		}
	    }

	    if ( q > array[0].length - 1 ){
		end = q; // for the right most cells
	    }

	    // now the number of cells in the same group is calculated and the end is saved
	    
	    for ( int i = end - (number * 2); i < end; i += 2 ) { // this iteration will guarantee that at least one will extend)
		if ((Math.random() * number) < 1.0) {
		    array[n + 1][i] = " ";
		    array[n + 2][i] = array[n][i]; // This will always work because extend should always be before the last row
		}
		else {
		    number --;
		}
	    } 
	    
	} 



	return high + 1; // this will be used in mergeRow to number the next few rows
    }

    public static void mergeRow( Object[][] array , int n, int prevHigh) {
	int counter = prevHigh;
	for( int i = 1; i < array[n].length - 1; i+=2 ) {
	    if ( ! (array[n][i] instanceof Integer) ) {
		array[n][i] = counter ++;
	    }
	}
	for( int i = 1; i < array[n].length - 2; i+=2 ) {
	    //showMaze (array);
	    if( Math.random() * 2 < 1 && ((Integer)array[n][i+2]).compareTo((Integer)array[n][i]) != 0) { // second condition makes sure that cells of the same set are not combined
		array[n][i+1] = " ";
		array[n][i+2] = array[n][i];
		
	    }
	}
    }
    
    

    public static Object[][] generate( Object[][] array ) {

	//initializes maze
	for( int i = 0; i < array.length; i++ ) {
	    for( int n = 0; n < array[i].length; n++ ) {
		if( i%2 == 0 ) {
                    array[i][n] = new Wall(false);
		}
		else {
		    if( n%2 == 0 ) {
			array[i][n] = new Wall(true);
		    }
		}
	    }
	}
	
	
	//showMaze( array );
	
	// First, generate the first row
	mergeRow( array, 1, 1 ); // row 1, counter starts at 1
	

	// Second, extend and merge the rest, except for the last one
	int holder = 3;
	for ( int c = 3; c < array.length -  2; c+=2 ) {
	    mergeRow ( array, c, extendRow( array, c - 2 ) );
	    holder = c + 2;
	}
	
	// The last row is a bit special
	int l = array.length - 2;
	int lastHigh = extendRow( array, holder - 2 );

	
	for ( int i = 1; i < array[holder].length - 1; i+=2 ) {
	    if ( ! (array[holder][i] instanceof Integer) ) {
		array[holder][i] = lastHigh ++;
	    }
	}
	for ( int c = 1; c < array[l].length - 2; c+=2 ) {
	    if ((((Integer)array[l][c]).compareTo((Integer)array[l][c+2])) != 0) {
		array[l][c+2] = array[l][c];
		array[l][c+1] = " ";
	    }
	}
	
    //showMaze( array );

    removeNums( array );
   
    removeStrings( array );
    //showMaze( array );

    return array;
    }

    private static void showMaze( Object[][] array ) {
        for( Object[] a : array ) {
            for( Object b : a ) {
                System.out.print( b );
            }
            System.out.println();
        }
    }

    private static void removeNums( Object[][] array ) {
	for (int i = 0; i < array.length; i ++ ) {
	    for (int c = 0; c < array[i].length; c++ ) {
		if (array[i][c] instanceof Integer) {
		    if ((Math.random())< 1.0/20) {
			Item a = new HpPotion();
			array[i][c] = new Floor(a);
		    }
		    else if ((Math.random()) < 1.0/9) {
			Item a = new Adrenaline();
			array[i][c] = new Floor(a);
		    }
		    else if ((Math.random())< 1.0/6) {
			Item a = new Item( "Money", (int) ( Math.random() * 31 ) + 10 );
			array[i][c] = new Floor(a);
		    }
		    else {
			array[i][c] = new Floor();
		    }
		}
	    }
	}
    }

    public static void removeStrings(Object[][] array) {
	for (int i = 0; i < array.length; i ++) {
	    for (int c = 0; c < array[i].length; c++ ) {
		if (array[i][c] instanceof String && array[i][c].equals(" ")){
		    if (Math.random() < 1.0/10) {
			Item a = new HpPotion();
			array[i][c] = new Floor(a);
		    }
		    else if (Math.random() < 1.0/9) {
			Item a = new Adrenaline();
			array[i][c] = new Floor(a);
		    }
		    else if (Math.random() < 1.0/6) {
			Item a = new Item( "Money", (int) ( Math.random() * 31 ) + 10 );
			array[i][c] = new Floor(a);
		    }
		    else {
			array[i][c] = new Floor();
		    }
		}
	    }
	}
	((Floor)array[array.length - 2][array[0].length -2]).monster = new Monster(); //So that last tile doesn't have a monster
    }

    public static void main( String[] args ) {

        MazeGen juan = new MazeGen(8,8);
	
	//System.out.print("\033[H\033[2J");  
	//System.out.flush();  
        generate(juan.maze);
	showMaze(juan.maze);
    }
}
