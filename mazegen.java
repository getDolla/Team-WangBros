public class mazegen{
    //instance avariables
    int r, c;
    Object[][] maze;

    public mazegen( int x, int y ) {
    if( (x>1) || (x<43) ) {
        r = 2*x+1;
    }

    else {
        r = 7;
    }

    if( (y>1) || (y>43) ) {
        c = 2*y+1;
    }

    else {
        c = 7;
    }

    maze = new Object[r][c];
    generate( maze );
    }

    public static Object[][] generate( Object[][] array ) {

    for( int i = 0; i < array.length; i++ ) {
        for( int n = 0; n < array[i].length; n++ ) {
            if( i%2 == 0 ) {
                    array[i][n] = "-";
            }
            else {
                if( n%2 == 0 && i != array.length-2 ) {
                    array[i][n] = "|";
                }
                else {
                    array[i][n] = " ";
                }
            }
        }
    }

    array[2][1] = " ";
    array[array.length-2][0] = "|";
    array[array.length-2][array.length-1] = "|";

    showmaze( array );

    for( int n = 1; n < array.length-2; n+=2 ) {
    for( int i = 1; i < array[n].length - 2; i+=2 ) {
        if( Math.random() * 3 < 1 ) {
            array[n][i+1] = " ";
            array[n][i+2] = array[n][i];
        }
        else if( array[n-1][i+1].equals(" ") ) {
            array[n][i+1] = " ";
        }
    }

    showmaze( array );

    int laspos = 0;

    for( int i = 1; i < array[n+1].length; i+=2 ) {
        if(array[n][i+1].equals("|")) {
            {
                if( (i - laspos) > 2 ) {
                for( int x = laspos + 1; x <= i; x++ ) {
                    if(array[n-1][x].equals(" ")) {
                        int rand = (int) (Math.random()*(i-laspos)) + laspos + 1;
                        array[n+1][rand] = " ";
                        break;
                    }
                }
                }

                else if ( Math.random() * 3 < 1 || array[n-1][i].equals(" ")) {
                    int rand = (int) (Math.random()*(i-laspos)) + laspos + 1;
                    array[n+1][rand] = " ";
                }
                laspos = i+1;

        }
        }
    }
            showmaze( array );
    }

    return array;
    }

    public static void showmaze( Object[][] array ) {
        for( Object[] a : array ) {
            for( Object b : a ) {
                System.out.print( b );
            }
            System.out.println();
        }
    }

    public static void main( String[] args ) {

        mazegen juan = new mazegen(8,8);

    }
}