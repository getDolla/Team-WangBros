public class Graphics {
    // 
    public static Object[][] inventory = new Object[10][30];
    public static String[][] stats = new String[5][30]; 
    public static String[][] monStats = new String[6][30];
    public static Object[][] graphics = new Object[15][30]; // Should not include monStats
    public static Object[][] equipped = new Object[20][20];
    public static String[][] settings = new String[20][20];
    public static Object[][] Display;

    public static String[] convertString( String str ) { //to make array rows
	String[] retStr = new String[str.length()];
	for (int c = 0; c < str.length(); c ++) {
	    retStr[c] = str.substring(c,c+1);
	}
	    
	return retStr;
    }



    private static Object[][] eraseArray( Object[][] array ){
	return (new Object[array.length][array[0].length]);
    }

    private static String[][] eraseArray( String[][] array ){
	return (new String[array.length][array[0].length]);
    }
       

    private static void addTo(Object[][] loc, String[] array, int pos ) {
	for (int i = 0; i < array.length; i++) {
	    loc[pos][i] = array[i];
	}
    }

    public static void updateEquipped (Character character) {
	equipped = eraseArray(equipped);
	addTo(equipped, convertString("Equipped Items:"),0);
	addTo(equipped, convertString("Armor: "),2);
	addTo(equipped, convertString("Weapon: "),5);
	for (int i = 0; i < character.equipped.size(); i++) {
	    Equipment temp = character.equipped.get(i);
	    if (temp instanceof Armor) {
		addTo(equipped, convertString(temp.name), 3);
	    }
	    if (temp instanceof Weapon) {
		addTo(equipped, convertString(temp.name),6);
	    }
	}
    }

    public static void updateInventory ( Character character) {
	inventory = eraseArray(inventory);
	String[] armorT = convertString("Armors: ");
	addTo(inventory,armorT,0);
	int l = 0;
	int m = 0;
	int h = 0;
	for( Armor a : character.armors ) {
		if( a instanceof Light ) {
			++l;
		}
		else if( a instanceof Medium ) {
			++m;
		}
		else if ( a instanceof Heavy ) {
			++h;
		}
	}
	String[] armorL = convertString("Light- " + l + "x");
        String[] armorM = convertString("Medium- " + m + "x");
	String[] armorH = convertString("Heavy- " + h + "x");
	addTo(inventory,armorL,1);
	addTo(inventory,armorM,2);
	addTo(inventory,armorH,3);


	addTo(inventory,convertString("Weapons: "),4);
	addTo(inventory,convertString(character.sticks.size() + "x"),5);

	addTo(inventory,convertString("Adrenaline: "),6);
	addTo(inventory,convertString(character.adren.size() + "x"),7);
	addTo(inventory,convertString( "Health Potions: "),8);
	addTo(inventory,convertString(character.healthdrinks.size() + "x"),9);

	}

    public static void updateStats ( Character character ) {
	stats = eraseArray(stats);
	String hp = "Hp = " + character.getHp();
	String speed = "Speed = "  + character.getSpeed();
	String damage = "Damage = " + character.getDamage();
	String luck = "Luck = " + character.getLuck();
	String money = "Money = " + character.getMoney();
	addTo(stats,convertString(hp),0);
	addTo(stats,convertString(speed),1);
	addTo(stats,convertString(damage),2);
	addTo(stats,convertString(luck),3);
	addTo(stats,convertString(money),4);
    }

    public static void updateMonStats ( Monster monster ) {
	monStats = eraseArray(monStats);
	String border = "";
	for (int i = 0; i < monStats[0].length; i++) {
	    border+="-";
	}
	String mon = "Monster: ";
	String name = "Name = " + monster.getName();
	String hp = "Hp = " + monster.getHp();
	String speed = "Speed = " + monster.getSpeed();
	String damage = "Damage = " + monster.getDamage();
	addTo(monStats,convertString(border),0);
	addTo(monStats,convertString(mon),1);
	addTo(monStats,convertString(name),2);
	addTo(monStats,convertString(hp),3);
	addTo(monStats,convertString(speed),4);
	addTo(monStats,convertString(damage),5);
    }

    public static void updateGraphics () {
	graphics = eraseArray(graphics);
	for( int i = 0; i < inventory.length; i++ ) {
	    for (int c = 0; c <inventory[i].length; c++) {
		graphics[i][c] = inventory[i][c];
	    }
	}
	int ctr = -1;
	for( int i = 0; i < stats.length; i++ ) {
	    for (int c = 0; c < stats[i].length; c++) {
		graphics[i + inventory.length][c] = stats[i][c];
	    }
	}

    }

    public static Object[][] displayMazeGraphics(Object[][] maze) {
	int size;
	if (graphics.length > maze.length) {
	    size = graphics.length;
	}
	else {
	    size = maze.length;
	}
	Display = new Object[size][maze[0].length+graphics[0].length+1];

	for (int c = 0; c < maze.length; c ++) {
	    for (int i = 0; i < maze[c].length; i++) {
		Display[c][i] = maze[c][i];
	    }
	}
	
	for (int c = 0; c < graphics.length; c ++) {
	    for (int i = 0; i < graphics[c].length; i++) {

		Display[c][maze[0].length + i + 1] = graphics[c][i];
	    }
	}
	//remove nulls
	
	for (int c = 0; c < Display.length; c++) {
	    for (int i = 0; i < Display[c].length; i++) {
		if (Display[c][i] == null) {
		    Display[c][i] = " ";
		}
	    }
	}
	return Display;
    }

    public static Object[][] displayBattleGraphics( String[][] battleMap ){
	int size;
	if ((graphics.length + monStats.length) > battleMap.length) {
	    size = (graphics.length + monStats.length);
	}
	else {
	    size = battleMap.length;
	}
	Display = new Object[size][battleMap[0].length + graphics[0].length];

	for (int c = 0; c < battleMap.length; c ++) {
	    for (int i = 0; i < battleMap[c].length; i++) {
		Display[c][i] = battleMap[c][i];
	    }
	}

	for (int c = 0; c < graphics.length; c ++) {
	    for (int i = 0; i < graphics[c].length; i++) {

		Display[c][battleMap[0].length + i] = graphics[c][i];
	    }
	}


	for (int c = 0; c < monStats.length; c++ ) {
	    for (int i = 0; i < monStats[c].length; i++) {
		Display[c + graphics.length ][battleMap[0].length + i] = monStats[c][i]; 
	    }
	}

	//remove nulls
	
	for (int c = 0; c < Display.length; c++) {
	    for (int i = 0; i < Display[c].length; i++) {
		if (Display[c][i] == null) {
		    Display[c][i] = " ";
		}
	    }
	}
	return Display;


    }

    public static Object[][] displayShopGraphics(Object[][] shop) {
	int size;
	if (graphics.length > shop.length) {
	    size = (graphics.length);
	}
	else {
	    size = shop.length;
	}
	Display = new Object[size][shop[0].length+shop[0].length];
	

	for (int c = 0; c < shop.length; c ++) {
	    for (int i = 0; i < shop[c].length; i++) {
		Display[c][i] = shop[c][i];
	    }
	}

	for (int c = 0; c < graphics.length; c ++) {
	    for (int i = 0; i < graphics[c].length; i++) {

		Display[c][shop[0].length + i] = graphics[c][i];
	    }
	}
	
	for (int c = 0; c < Display.length; c++) {
	    for (int i = 0; i < Display[c].length; i++) {
		if (Display[c][i] == null) {
		    Display[c][i] = " ";
		}
	    }
	}
	return Display;

    }

    public static Object[][] displayEquippedGraphics() {
	int size;
	if (graphics.length > equipped.length) {
	    size = graphics.length;
	}
	else {
	    size = equipped.length;
	}
	Display = new Object[size][equipped[0].length+graphics[0].length+1];

	for (int c = 0; c < equipped.length; c ++) {
	    for (int i = 0; i < equipped[c].length; i++) {
		Display[c][i] = equipped[c][i];
	    }
	}
	
	for (int c = 0; c < graphics.length; c ++) {
	    for (int i = 0; i < graphics[c].length; i++) {

		Display[c][equipped[0].length + i + 1] = graphics[c][i];
	    }
	}
	//remove nulls
	
	for (int c = 0; c < Display.length; c++) {
	    for (int i = 0; i < Display[c].length; i++) {
		if (Display[c][i] == null) {
		    Display[c][i] = " ";
		}
	    }
	}
	return Display;
    }

}
