import java.util.Scanner; 
public class Engine {
    
    public static Object[][] userMap; // One map for all
    public static Character character; // One character for all
    public static BattleMap battleMap;
    public static Monster monster; // only one monster to exist at a time FLAG


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

    private static void updateMazeGraphics(){
	newLvl();
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayMazeGraphics(userMap));
    }

    public static void moveUp(int r, int c) {
	if (!(userMap[r-1][c]  instanceof Wall)) { //if not blocked by border
	    autoPickup( r-1, c );
	    userMap[r][c] = character.tileUnder;
	    userMap[r - 1][c] = character.appearance;
	    character.setRLocation(r - 1);
	    if ( ((Floor) userMap[r-1][c]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r-1][c]).monster;
	    }
	}
	updateMazeGraphics();
    }

    public static void moveDown(int r, int c) {
	if (!(userMap[r+1][c]  instanceof Wall)) { //if not blocked by border
	    autoPickup( r+1, c );
	    userMap[r][c] = character.tileUnder;
	    userMap[r + 1][c] = character.appearance;
	    character.setRLocation(r + 1);
	    if ( ((Floor) userMap[r+1][c]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r+1][c]).monster;
	    }
	}

    }

    public static void moveLeft(int r, int c) {
	if (!(userMap[r][c-1]  instanceof Wall)) { //if not blocked by border
	    autoPickup( r, c-1 );
	    userMap[r][c] = character.tileUnder;
	    userMap[r][c - 1] = character.appearance;
	    character.setCLocation(c - 1);
	    if ( ((Floor) userMap[r][c - 1]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r][c - 1]).monster;
	    }
	}
	updateMazeGraphics();
    }
    
    public static void moveRight(int r, int c) {
	if (!(userMap[r][c+1] instanceof Wall)) { //if not blocked by border
	    autoPickup( r, c+1 );
	    userMap[r][c] = character.tileUnder;
	    userMap[r][c + 1] = character.appearance;
	    character.setCLocation(c + 1);
	    if ( ((Floor) userMap[r][c + 1]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r][c + 1]).monster;
	    }
	}
    	updateMazeGraphics();
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

    public static void move() {

	    Scanner input = new Scanner(System.in);
	    clearConsole();
	    Graphics.updateInventory(character);
	    Graphics.updateStats(character);
	    Graphics.updateGraphics();
	    printArray(Graphics.displayMazeGraphics(userMap));
	if (! character.inBattle) {	
	    String in = input.nextLine();
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

    public static void updateBattleGraphics() {
	battleMap = new BattleMap(character,monster);
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateMonStats(monster);
	Graphics.updateGraphics();
	printArray(Graphics.displayBattleGraphics( battleMap.map ));
    }

    public static void battle() {
	while ( monster.hp > 0 && character.hp > 0 ) {
	    updateBattleGraphics();
	    character.printAttacks();
	    Scanner input = new Scanner(System.in);
	    String in = input.nextLine();
	    // use CurrentTimeMillis along with BattleMap to animate attack FLAG
	    String attack = "did nothing";
	    if (in.equals("1")){
		attack = "used " + character.attack1( monster, battleMap );
	    }
	    else if (in.equals("2")){
		attack = "used " + character.attack2( monster, battleMap );
	    }
	    else if (in.equals("3")){
		attack = "used " + character.attack3( monster, battleMap );
	    }
	    else if (in.equals("4")){
		attack = "used " + character.attack4( monster, battleMap );
	    }
	    else if (in.equals("5")) { // Run Away
		if (Math.random() * character.luck < 30) {
		    character.inBattle = false;
		    attack = "ran away sucessfully";
		}
		else {
		    attack = "failed to run away";
		}
	    }
	    else if (in.equals("6")) { // Use Items
		
	    }
	    // use CurrentTimeMillis along with BattleMap for monster attack FLAG
	    updateBattleGraphics();
	    System.out.println("You " + attack);

	    System.out.println("Press any key to continue");
	    Scanner con1 = new Scanner(System.in);
	    String contin1 = con1.nextLine();
	    if (!character.inBattle){ //ran away
		break;
	    }
	    
	    if (monster.hp > 0) {
		monster.attack(character, battleMap);
		updateBattleGraphics();
		System.out.println(monster.name + " attacked");
		System.out.println("Press any key to continue");
		Scanner con2 = new Scanner(System.in);
		String contin2 = con2.nextLine();
	    }
	    
	}
	
	character.inBattle = false;
    }

    
}
