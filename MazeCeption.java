import java.util.Scanner; 

public class MazeCeption {

    //    private int stage = 0;
    public String name = "Bob";

    private String[][] title = new String[][]{
	Graphics.convertString("___  ___              _____            _   _             "),
	Graphics.convertString("|  \\/  |             /  __ \\          | | (_)            "),
	Graphics.convertString("| .  . | __ _ _______| /  \\/ ___ _ __ | |_ _  ___  _ __  "),
	Graphics.convertString("| |\\/| |/ _` |_  / _ \\ |    / _ \\ '_ \\| __| |/ _ \\| '_ \\ "),
	Graphics.convertString("| |  | | (_| |/ /  __/ \\__/\\  __/ |_) | |_| | (_) | | | |"),
	Graphics.convertString("\\_|  |_/\\__,_/___\\___|\\____/\\___| .__/ \\__|_|\\___/|_| |_|"),
	Graphics.convertString("                                | |                      "),
	Graphics.convertString("                                |_|                      ")
    };
    
    public MazeCeption() {
	newGame();
    }
    
    public void newGame() {
	boolean chosenClass = false;
	boolean chosenName = false;
	Scanner entrance = new Scanner(System.in);
	boolean entered = false;
	boolean tutorialMode = true;
	String enter; // for all user inputs

	printTitle();
		
	while (!entered) {
	    System.out.println("Press enter to begin");
	    enter = entrance.nextLine();
	    entered = true;
	    
	}
	
	
	while (!chosenClass) {

	
	    printTitle();
	
	    System.out.println( "Welcome to MazeCeption!" );	
	
	    System.out.println( );       
	    
	    while (!chosenName){
		
		System.out.println( "What's your name?" );
		
		enter = entrance.nextLine();
		
		System.out.println( "Your name is "+ enter + ".");
		
		if (confirm()) {
		    name = enter;
		    chosenName = true;
		}
		else if (!chosenName) {
		    System.out.println("Your default name will be Bob.");
		    if (confirm()) {
			chosenName = true;
		    }
		}
		
		
	    }

	    /*
	      if (tutorialMode) {
	      System.out.println("Would you like a tutorial?(YES/NO)");
	      enter = entrance.nextLine();
	      if (enter.toUpperCase().equals("YES")) {
	      tutorial();
	      tutorialMode = false;
	      }
	      if (enter.toUpperCase().equals("NO")) {
	      tutorialMode = false;
	      }
	      }
	    */
	    System.out.println();

	    System.out.println("Hello " + name + ".");
	    System.out.println();

	    System.out.println( "Choose your character:" );
	
	    System.out.println( "Tank" );
	    System.out.println( "Ninja" );
	    System.out.println( "DemoMan" );
	    System.out.println( "DankMeme" );
	    System.out.println();
	
	    Scanner in = new Scanner( System.in );
	
	    String choice = in.nextLine();
		
	    if ( choice.toUpperCase().equals( "TANK" ) ) {
	    	showCharinfo( new Tank(name) );
		if( confirm() ) {
		    Engine.character = new Tank(name);
		    chosenClass = true;
		}
	    } 
	    
	    else if ( choice.toUpperCase().equals( "NINJA" ) ) {
		showCharinfo( new Ninja(name) );
		if( confirm() ) {
		    Engine.character = new Ninja(name);
		    chosenClass = true;
		}
	    }
	    
	    else if ( choice.toUpperCase().equals( "DEMOMAN" ) ) {
		showCharinfo( new DemoMan(name) );
		if( confirm() ) {
		    Engine.character = new DemoMan(name);
		    chosenClass = true;
		}
	    }
	    
	    else if ( choice.toUpperCase().equals( "DANKMEME" ) ) {
		showCharinfo( new DankMeme(name) );
		if( confirm() ) {
		    Engine.character = new DankMeme(name);
		    chosenClass = true;
		}
	    
	    }


	    Engine.clearConsole();
	    
	}

	Engine.fillMap();
    }

    public void printTitle() {
	boolean entered = false;
	String enter;
	Engine.clearConsole();
	Scanner entrance = new Scanner(System.in);	
	    for (String[] f : title) {
		for (String s : f) {
		    System.out.print(s);
		}
		System.out.println();
	    }
	    System.out.println("By: Team-WangBros");
    }

    public void showCharinfo( Character c ) {
	System.out.println( c.name );
	c.displaystats();

	Engine.printArray( c.image );
	System.out.println();
    }

    public boolean confirm() { 
    	System.out.println( "Are you sure? (YES/NO)" );

    	Scanner in = new Scanner( System.in );
	    
	String s = in.nextLine();

    	if( s.toUpperCase().equals( "YES" ) ) {
	    return true;
    	}

    	return false;
    }

    public void tutorial() {
	Engine.clearConsole();
	Engine.character = new Tank();
	Engine.stage = -5; //for a small map
	Engine.fillMap();
	boolean condition =  Engine.character.getHp() > 0 && Engine.stage == -5;
	while ( condition ) {
	    while (!Engine.character.inBattle && condition) {
		Engine.move();
	    }
	    while (Engine.character.inBattle && condition) {
		Engine.battle();
	    }
	}
    }
	
    public void play() {
	while ( Engine.character.getHp() > 0 ) {
	    while (!Engine.character.inBattle) {
		Engine.move();
	    }
	    while (Engine.character.inBattle) {
		Engine.battle();
	    }
	}
    }
    
    public static void main( String[] args ) {
	MazeCeption m = new MazeCeption();
	m.play();
	
    }
}
