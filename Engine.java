import java.util.Scanner;
public class Engine {
    
    public static Object[][] trueMap;
    public static Object[][] userMap;
    public static Character character = new Character();

    public static void printMap() {
	for (Object[] f : userMap) {
	    for (Object s : f) {
		System.out.print(s);
	    }
	    System.out.println();
	}
    }

    public static void fillMap() {
	MazeGen john = new MazeGen( 10, 10 );

	trueMap = MazeGen.generate( john.maze );
	userMap = new Object[trueMap.length][trueMap.length];
		for( int r = 0; r < trueMap.length; r++ ) {
			for( int c = 0; c < trueMap[r].length; c++ ) {
				userMap[r][c] = trueMap[r][c]; //populate, not same alias
			}
		}
	 
	userMap[1][1] = character;
	character.setCLocation(1);
	character.setRLocation(1);
    }
    
    public final static void clearConsole(){
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }

    public static void moveUp(int r, int c) {
	if (!userMap[r-1][c].equals("-")) { //if not blocked by border
	    userMap[r][c] = trueMap[r][c];
	    userMap[r - 1][c] = character;
	    character.setRLocation(r - 1);
	}
    }

    public static void moveDown(int r, int c) {
	if (!userMap[r+1][c].equals("-")) { //if not blocked by border
	    userMap[r][c] = trueMap[r][c];
	    userMap[r + 1][c] = character;
	    character.setRLocation(r + 1);
	}
    }

    public static void moveLeft(int r, int c) {
	if (!userMap[r][c-1].equals("|") && !userMap[r][c-1].equals("-")) { //if not blocked by border
	    userMap[r][c] = trueMap[r][c];
	    userMap[r][c - 1] = character;
	    character.setCLocation(c - 1);
	}
    }
    
    public static void moveRight(int r, int c) {
	if (!userMap[r][c+1].equals("|") && !userMap[r][c+1].equals("-")) { //if not blocked by border
	    userMap[r][c] = trueMap[r][c];
	    userMap[r][c + 1] = character;
	    character.setCLocation(c + 1);
	}
    }

    public static boolean isEnd() {
	int r = character.getRLocation();
	int c = character.getCLocation();

	return (r == trueMap.length - 2) && (c == trueMap[r].length - 2);
    }

    public static void newlvl() { 
	if(isEnd()) { 
	    fillMap();
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
	printMap();
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

	    newlvl();
	    
	    }
	    clearConsole();
	    printMap();

	}
    }
}
