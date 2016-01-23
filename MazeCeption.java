import java.util.Scanner; 

public class MazeCeption {
    private int stage = 0;
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
	Engine.clearConsole();
	Scanner entrance = new Scanner(System.in);	
	for (String[] f : title) {
	    for (String s : f) {
		System.out.print(s);
	    }
	    System.out.println();
	}
	
	System.out.println("By: Team-WangBros");
	System.out.println("Press enter to begin");
	String enter = entrance.nextLine();
	
	


	System.out.println( "Welcome to MazeCeption!" );	
	
	System.out.println( );       

	boolean chosenClass = false;
	
	while (!chosenClass) {
		System.out.println( "Choose your character:" );

		System.out.println( "Tank" );
		System.out.println( "Ninja" );
		System.out.println( "DemoMan" );
		System.out.println( "DankMeme" );

	    Scanner in = new Scanner( System.in );
	    
	    String choice = in.nextLine();
	    
	    if ( choice.toUpperCase().equals( "TANK" ) ) {
	    	showCharinfo( new Tank() );
	    		if( confirm() ) {
					Engine.character = new Tank();
					chosenClass = true;
				}
	    } 
	    
	    else if ( choice.toUpperCase().equals( "NINJA" ) ) {
			showCharinfo( new Ninja() );
	    		if( confirm() ) {
					Engine.character = new Ninja();
					chosenClass = true;
				}
	    }
	    
	    else if ( choice.toUpperCase().equals( "DEMOMAN" ) ) {
			showCharinfo( new DemoMan() );
	    		if( confirm() ) {
					Engine.character = new DemoMan();
					chosenClass = true;
				}
	    }
	    
	    else if ( choice.toUpperCase().equals( "DANKMEME" ) ) {
			showCharinfo( new DankMeme() );
	    		if( confirm() ) {
					Engine.character = new DankMeme();
					chosenClass = true;
				}
	    
	    	}


    	Engine.clearConsole();
	    
	    }

	    Engine.fillMap();
	}

	public void showCharinfo( Character c ) {
		System.out.println( c.name );
		c.displaystats();

		Engine.printArray( c.image );
		System.out.println();
    }

    public boolean confirm() { 
    	System.out.println( "Do you want this class? (YES/NO)" );

    	Scanner in = new Scanner( System.in );
	    
	    String s = in.nextLine();

    	if( s.toUpperCase().equals( "YES" ) ) {
    		return true;
    	}

    	return false;
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
