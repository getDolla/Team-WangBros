import java.util.Scanner; 

public class MazeCeption {
    protected int stage = 0;
    
    public MazeCeption() {
	newGame();
    }
    
    public void newGame() {
	System.out.println( "Welcome to MazeCeption!" );
	
	System.out.println( "Choose your character:" );

	System.out.println( "Tank" );
	System.out.println( "Ninja" );
	System.out.println( "DemoMan" );
	System.out.println( "DankMeme" );
	
	
	System.out.println( );       

	boolean chosenClass = false;
	
	while (!chosenClass) {

	    Scanner in = new Scanner( System.in );
	    
	    String choice = in.nextLine();
	    
	    if ( choice.toUpperCase().equals( "TANK" ) ) {
		Engine.character = new Tank();
		chosenClass = true;
	    } 
	    
	    else if ( choice.toUpperCase().equals( "NINJA" ) ) {
		Engine.character = new Ninja();
		chosenClass = true;
	    }
	    
	    else if ( choice.toUpperCase().equals( "DEMOMAN" ) ) {
		Engine.character = new DemoMan();
		chosenClass = true;
	    }
	    
	    else if ( choice.toUpperCase().equals( "DANKMEME" ) ) {
		Engine.character = new DankMeme();
		chosenClass = true;
	    }
	    
	    Engine.fillMap();

	    
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
