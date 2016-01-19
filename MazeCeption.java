import java.util.Scanner; 

public class MazeCeption {
	protected int stage = 0;

	public MazeCeption() {
		newgame();
	}

	public void newgame() {
		System.out.println( "Welcome to MazeCeption!" );

		System.out.println( "Choose your character:" );
		
		System.out.println( "Tank:" );
		(new Tank()).displaystats();

		System.out.println( "" );
		Engine.fillMap();
	}

	public static void main( String[] args ) {
		MazeCeption m = new MazeCeption();
	}
}