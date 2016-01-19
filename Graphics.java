public class Graphics {
    // 
    public static Object[][] inventory = new Object[4][2];
    public static String[] stats = new String[5];
    public static Object[][] graphics = new Object[9][2];


    public static void updateInventory ( Character character) {
	inventory[0][0] = "Armors: ";

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

	inventory[0][1] = "Light- " + l + "x    " + "Medium- " + m + "x    " + "Heavy- " + h + "x";

	inventory[1][0] = "Weapons: ";
	inventory[1][1] = character.sticks.size() + "x";

	inventory[2][0] = "Adrenaline: ";
	inventory[2][1] = character.adren.size() + "x";

	inventory[3][0] = "Health Potions: ";
	inventory[3][1] = character.healthdrinks.size() + "x";
	}

    public static void updateStats ( Character character ) {
	stats[0] = "Hp = " + character.hp;
	stats[1] = "Speed = "  + character.speed;
	stats[2] = "Damage = " + character.damage;
	stats[3] = "Luck = " + character.luck;
	stats[4] = "Money = " + character.money;
    }
    
    public static void updateGraphics () {
	for( int i = 0; i < inventory.length; i++ ) {
	    for (int c = 0; c <inventory[i].length; c++) {
		graphics[i][c] = inventory[i][c];
	    }
	}
	for( int i = inventory.length + 1; i < graphics.length; i++ ) {
	    graphics[i][0] = stats[i - inventory.length];
	}
    }

    public static Object[][] displayMazeGraphics(Object[][] maze) {
        Object[][] Display = new Object[21][51]; // 25*2+1 length and 10*2+1 width(vertical) for maze, 10 for inventory 
	for (int c = 0; c < maze.length; c ++) {
	    for (int i = 0; i < maze[c].length; i++) {
		Display[c][i] = maze[c][i];
	    }
	}
	
	for (int c = 0; c < graphics.length; c ++) {
	    for (int i = 0; i < graphics[c].length; i++) {

		Display[c][25 + i] = graphics[c][i];
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
