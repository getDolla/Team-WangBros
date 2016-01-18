public class Graphics {
    // 
    public Object[][] inventory = new Object[8][10];
    public String[] stats = new String[5];
    public Object[][] graphics = new Object[13][10];

    
    

    public static void updateInventory (Object[][] inventory, Character character) {
	inventory[0][0] = "Armor";
	Object[] armors = character.armors.toArray();
	for (int i = 0; i < armors.length; i++) {
	    inventory[1][i] = armors[i];
	}
	inventory[2][0] = "Weapons";
	Object[] sticks = character.sticks.toArray();
	for (int i = 0; i < sticks.length; i++) {
	    inventory[3][i] = sticks[i];
	}
	inventory[4][0] = "Adrenaline";
	Object[] adren = character.adren.toArray();
	for (int i = 0; i < adren.length; i++) {
	    inventory[5][i] = adren[i];
	}
	inventory[6][0] = "Health Potions";
	Object[] healthdrinks = character.healthdrinks.toArray();
	for (int i = 0; i < healthdrinks.length; i++) {
	    inventory[7][i] = healthdrinks[i];
	}
    }

    public static void updateStats ( String[] stats, Character character ) {
	stats[0] = "Hp = " + character.hp;
	stats[1] = "Speed = "  + character.speed;
	stats[2] = "Damage = " + character.damage;
	stats[3] = "Luck = " + character.luck;
	stats[4] = "Money = " + character.money;
    }
    
    public void updateGraphics () {
	for( int i = 0; i < inventory.length; i++ ) {
	    for (int c = 0; c <inventory[i].length; c++) {
		graphics[i][c] = inventory[i][c];
	    }
	}
	for( int i = inventory.length; i < graphics.length; i++ ) {
	    graphics[i][0] = stats[i - inventory.length];
	}
    }

    public static Object[][] displayMazeGraphics(Object[][] maze, Object[][] graphics) {
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
