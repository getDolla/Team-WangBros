import java.util.Scanner; 
public class Engine {
    
    public static Object[][] userMap; // One map for all
    public static Character character = new Character(); // One character for all

    public static void printArray(Object[][] array) {
	for (Object[] f : array) {
	    for (Object s : f) {
		System.out.print(s);
	    }
	    System.out.println();
	}
    }

    public static void fillMap() {
	MazeGen john = new MazeGen( 10, 10 );

	userMap = MazeGen.generate( john.maze );
	 
	userMap[1][1] = character;
	character.setCLocation(1);
	character.setRLocation(1);
    }
    
    public final static void clearConsole(){
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }

    public static void moveUp(int r, int c) {
	if (!(userMap[r-1][c]  instanceof Wall)) { //if not blocked by border
		autoPickup( r-1, c );
	    userMap[r][c] = character.tileUnder;
	    userMap[r - 1][c] = character.appearance;
	    character.setRLocation(r - 1);
	}
	newLvl();
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
    }

    public static void moveDown(int r, int c) {
	if (!(userMap[r+1][c]  instanceof Wall)) { //if not blocked by border
		autoPickup( r+1, c );
	    userMap[r][c] = character.tileUnder;
	    userMap[r + 1][c] = character.appearance;
	    character.setRLocation(r + 1);
	}
	newLvl();
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
    }

    public static void moveLeft(int r, int c) {
	if (!(userMap[r][c-1]  instanceof Wall)) { //if not blocked by border
		autoPickup( r, c-1 );
	    userMap[r][c] = character.tileUnder;
	    userMap[r][c - 1] = character.appearance;
	    character.setCLocation(c - 1);
	}
	newLvl();
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
    }
    
    public static void moveRight(int r, int c) {
	if (!(userMap[r][c+1] instanceof Wall)) { //if not blocked by border
		autoPickup( r, c+1 );
	    userMap[r][c] = character.tileUnder;
	    userMap[r][c + 1] = character.appearance;
	    character.setCLocation(c + 1);
	}
	newLvl();
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
    }

    public static boolean isEnd() {
	int r = character.getRLocation();
	int c = character.getCLocation();

	return (r == userMap.length - 2) && (c == userMap[r].length - 2);
    }

    public static void newLvl() { 
	if(isEnd()) { 
	    fillMap();
	}
    }

    public static void autoPickup( int r, int c ) {
    	if( (userMap[r][c] instanceof Floor) && !((Floor) userMap[r][c]).item.name.equals( "None" ) ) {
    		character.pickup( ((Floor) userMap[r][c]).item );
    	}
    }

    public static void main(String[] args) {
	/*
	Scanner rawName = new Scanner(System.in);
	String name = rawName.nextLine();

	*/

	fillMap();
	Scanner input = new Scanner(System.in);
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
	while (input.hasNext()) {
	    
	    String in = input.nextLine();
	    if (in.toUpperCase().equals("EXIT")) {
		break;
		}
		else {
	    if (in.toUpperCase().equals("W")) { //FPS keys :D
		moveUp(character.getRLocation(), (character.getCLocation()));
	    }
	    else if (in.toUpperCase().equals("A")) {
		moveLeft(character.getRLocation(), (character.getCLocation()));
	    }
	    else if (in.toUpperCase().equals("S")) {
		moveDown(character.getRLocation(), (character.getCLocation()));
	    }
	    else if (in.toUpperCase().equals("D")) {
		moveRight(character.getRLocation(), (character.getCLocation()));
	    }
	    
	    }


	}
    }
}
