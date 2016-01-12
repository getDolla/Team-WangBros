import java.util.Scanner;
public class Engine {
    
    public static Object[][] trueMap = new Object[10][10];
    public static Object[][] userMap = new Object[10][10];
    public static Character character = new Character();

    public Engine() {
	 fillMap();
	 userMap[0][0] = character;
    }

    public static void printMap() {
	for (Object[] f : userMap) {
	    for (Object s : f) {
		System.out.print(s);
	    }
	    System.out.println();
	}
    }

    public static void fillMap() {
	for (int f = 0; f < userMap.length; f++) {
	    for (int s = 0; s < userMap[f].length; s++) {
		trueMap[f][s] = " ";
		userMap[f][s] = " ";
	    }
	}
    }
    
    public final static void clearConsole(){
	System.out.print("\033[H\033[2J");  
	System.out.flush();  
    }

    public static void moveUp(int r, int c) {
	if (r > 0) {
	    userMap[r][c] = trueMap[r][c];
	    userMap[r - 1][c] = character;
	    character.setRLocation(r - 1);
	}
    }

    public static void moveDown(int r, int c) {
	if (r < 9) {
	    userMap[r][c] = trueMap[r][c];
	    userMap[r + 1][c] = character;
	    character.setRLocation(r + 1);
	}
    }

    public static void moveLeft(int r, int c) {
	if (c > 0) {
	    userMap[r][c] = trueMap[r][c];
	    userMap[r][c - 1] = character;
	    character.setCLocation(c - 1);
	}
    }
    
    public static void moveRight(int r, int c) {
	if (c < 9) {
	    userMap[r][c] = trueMap[r][c];
	    userMap[r][c + 1] = character;
	    character.setCLocation(c + 1);
	}
    }

    public static void main(String[] args) {
	/*
	Scanner rawName = new Scanner(System.in);
	String name = rawName.nextLine();

	*/
	Engine game = new Engine();
	Scanner input = new Scanner(System.in);
	clearConsole();
	printMap();
	while (input.hasNext()) {
	    
	    String in = input.nextLine();
	    if (in.toUpperCase().equals("W")) {
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
	    else if (in.toUpperCase().equals("EXIT")) {
		break;
	    }
	    clearConsole();
	    printMap();

	}
    }
}
