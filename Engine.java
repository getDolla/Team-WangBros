import java.util.Scanner; 
public class Engine {
    
    public static Object[][] userMap; // One map for all
    public static Character character; // One character for all
    public static BattleMap battleMap;
    public static Shop shop = new Shop();
    public static Monster monster; // only one monster to exist at a time


    public static void printArray(Object[][] array) {
	for (Object[] f : array) {
	    for (Object s : f) {
		if (!(s.toString().equals("*"))) {
		    System.out.print(s);
		}
		else {
		    System.out.print("\u001B[35m" + s + "\u001B[0m");
		}
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
    
    public final static void pressEnter() {
	System.out.println("Press enter to continue");
	Scanner con1 = new Scanner(System.in);
	String contin1 = con1.nextLine();
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

	    if ( ((Floor) userMap[r-1][c]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r-1][c]).monster;
	    }

	   	userMap[r - 1][c] = character.appearance;
	    character.setRLocation(r - 1);
	}
	updateMazeGraphics();
    }

    public static void moveDown(int r, int c) {
	if (!(userMap[r+1][c]  instanceof Wall)) { //if not blocked by border
	    autoPickup( r+1, c );
	    userMap[r][c] = character.tileUnder;

	    if ( ((Floor) userMap[r+1][c]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r+1][c]).monster;
	    }

	    userMap[r + 1][c] = character.appearance;
	    character.setRLocation(r + 1);
	}
		updateMazeGraphics();
    }

    public static void moveLeft(int r, int c) {
	if (!(userMap[r][c-1]  instanceof Wall)) { //if not blocked by border
	    autoPickup( r, c-1 );
	    userMap[r][c] = character.tileUnder;

	    if ( ((Floor) userMap[r][c - 1]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r][c - 1]).monster;
	    }

	    userMap[r][c - 1] = character.appearance;
	    character.setCLocation(c - 1);
	}
	updateMazeGraphics();
    }
    
    public static void moveRight(int r, int c) {
	if (!(userMap[r][c+1] instanceof Wall)) { //if not blocked by border
	    autoPickup( r, c+1 );
	    userMap[r][c] = character.tileUnder;

	    if ( ((Floor) userMap[r][c + 1]).hasMon() ) {
		character.inBattle = true;
		monster = ((Floor) userMap[r][c + 1]).monster;
	    }

	    userMap[r][c + 1] = character.appearance;
	    character.setCLocation(c + 1);
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
	    character.isShopping = true;
	    while (character.isShopping) {
		shop();
	    }
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
	if (!(character.inBattle) && !(character.isShopping)) {	
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
	    else if (in.toUpperCase().equals("DRINK")) {
		chooseDrink();
	    }
	    else if (in.toUpperCase().equals("SETTINGS")) {
		character.settingsMode = true;
		while (character.settingsMode) {
		    settings();
		}
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
		if (Math.random() * character.getLuck() > 50 ) {
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

	    pressEnter();
	    if (!character.inBattle){ //ran away
		break;
	    }
	    
	    if (monster.hp > 0) {
		int h = monster.attack(character, battleMap);
		updateBattleGraphics();
		System.out.println(monster.name + " did " + h + " hit points.");
		pressEnter();
	    }
	    
	}
	
	character.inBattle = false;
    }

    public static void shop() {
	clearConsole();
	Graphics.updateInventory(character);
	Graphics.updateStats(character);
	Graphics.updateGraphics();
	printArray(Graphics.displayShopGraphics(shop.shop));
	Scanner input = new Scanner(System.in);
	String in = input.nextLine();
	if (in.toUpperCase().equals("EXIT")) {
	    character.isShopping = false;
	}
	else if (in.toUpperCase().equals("B1")) {
	    character.purchase(new HpPotion());
	}
	else if (in.toUpperCase().equals("B2")) {
	    character.purchase(new Adrenaline());
	}

	else if (in.toUpperCase().equals("B3")) {
	    character.purchase(new Light());
	}

	else if (in.toUpperCase().equals("B4")) {
	    character.purchase(new Medium());
	}

	else if (in.toUpperCase().equals("B5")) {
	    character.purchase(new Heavy());
	}

	else if (in.toUpperCase().equals("B6")) {
	    character.purchase(new Twig());
	}

	else if (in.toUpperCase().equals("B7")) {
	    character.purchase(new Sword());
	}
	else if (in.toUpperCase().equals("S1")) {
	    character.sell(new HpPotion());
	}
	else if (in.toUpperCase().equals("S2")) {
	    character.sell(new Adrenaline());
	}

	else if (in.toUpperCase().equals("S3")) {
	    character.sell(new Light());
	}

	else if (in.toUpperCase().equals("S4")) {
	    character.sell(new Medium());
	}

	else if (in.toUpperCase().equals("S5")) {
	    character.sell(new Heavy());
	}

	else if (in.toUpperCase().equals("S6")) {
	    character.sell(new Twig());
	}

	else if (in.toUpperCase().equals("S7")) {
	    character.sell(new Sword());
	}

	
    }


    public static void chooseDrink() {
	System.out.println("Choose a drink: ");
	System.out.println("1. HpPotion \t 2. Adrenaline");
	Scanner in = new Scanner(System.in);
	String input = in.nextLine();
	if (input.equals("1")) {
	    if (character.healthdrinks.size() == 0) {
		System.out.println("You do not have Hp Potions");
		pressEnter();
	    }
	    else {
		System.out.println( "You now have " + character.drink(character.healthdrinks.get(0)) + " health." );
		pressEnter();
	    }
	}
	else if (input.equals("2")) {
	    if (character.adren.size() == 0) {
		System.out.println("You do not have Adrenaline Potions");
		pressEnter();
	    }
	    else {
		System.out.println( "You now have " + character.drink(character.adren.get(0)) + " speed." );
		pressEnter();
	    }
	}
    }

    public static void chooseEquipment() {
	boolean exitMode = false;
	while(!exitMode) {
	    clearConsole();
	    Graphics.updateInventory(Character);
	    Graphics.updateStats(character);
	    Graphics.updateGraphics();
	    Graphics.updateEquipping(character);
	    printArray(Graphics.displayEquippingGraphics());
	    Scanner input = new Scanner(System.in);
	    String in = input.nextLine();
	    if (in.toUpperCase().equals("BACK") || in.toUpperCase().equals("EXIT")) {
		exitMode = true;
	    }
	    if (Graphics.avalEquips[0] != null && in.toUpperCase().equals(Graphics.avalEquips[0].name.toUpperCase())) {
		character.equip( Graphics.avalEquips[0]);
	    }
	    if (Graphics.avalEquips[1] != null && in.toUpperCase().equals(Graphics.avalEquips[1].name.toUpperCase())) {
		character.equip( Graphics.avalEquips[1]);
	    }
	    if (Graphics.avalEquips[2] != null && in.toUpperCase().equals(Graphics.avalEquips[2].name.toUpperCase())) {
		character.equip( Graphics.avalEquips[2]);
	    }
	    if (Graphics.avalEquips[3] != null && in.toUpperCase().equals(Graphics.avalEquips[3].name.toUpperCase())) {
		character.equip( Graphics.avalEquips[3]);
	    }
	    if (Graphics.avalEquips[4] != null && in.toUpperCase().equals(Graphics.avalEquips[4].name.toUpperCase())) {
		character.equip( Graphics.avalEquips[4]);
	    }
	}	
    }

 public static void removeEquipment() {
	boolean exitMode = false;
	while(!exitMode) {
	    clearConsole();
	    Graphics.updateInventory(character);
	    Graphics.updateStats(character);
	    Graphics.updateGraphics();
	    Graphics.updateEquipping(character);
	    Graphics.updateEquipped(character);
	    printArray(Graphics.displayEquippedGraphics());
	    Scanner input = new Scanner(System.in);
	    String in = input.nextLine();
	    if (in.toUpperCase().equals("BACK") || in.toUpperCase().equals("EXIT")) {
		exitMode = true;
	    }
	    if (character.equipped.size() > 0 && in.toUpperCase().equals(character.equipped.get(0).name.toUpperCase())) {
		character.unequip(character.equipped.get(0));
	    }
	    if (character.equipped.size() > 1 && in.toUpperCase().equals(character.equipped.get(1).name.toUpperCase())) {
		character.unequip(character.equipped.get(1));
	    }
	}	
    }


    public static void settings() {
	clearConsole();
	printArray(Graphics.displaySettingsGraphics());
	Scanner input = new Scanner(System.in);
	String in = input.nextLine();
	if (in.toUpperCase().equals("EXIT") || in.toUpperCase().equals("BACK")) {
	    character.settingsMode = false;
	}
	if (in.equals("1")) {
	    chooseEquipment();
	}
	if (in.equals("2")) {
	    removeEquipment();
	}
	if (in.equals("3")) {
	    checkEquipment();
	}
	
    }

    public static void checkEquipment() {
	String in = "";
	while (!((in.toUpperCase().equals("EXIT") ^ in.toUpperCase().equals("BACK")))) {
	    Scanner esc = new Scanner(System.in);
	    clearConsole();
	    Graphics.updateStats(character);
	    Graphics.updateEquipped(character);
	    printArray(Graphics.displayEquippedGraphics());
	    in = esc.nextLine();
	}
    }
    
}
