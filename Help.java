public class Help {
    public String[][] helpScreen = new String[46][62];
    public String[][] attackinfo = new String[30][60];

    public Help() {
	create();
	showattackinfo();
    }

    private static String[] convertString( String str ) { //to make array rows
	String[] retStr = new String[str.length()];
	for (int c = 0; c < str.length(); c ++) {
	    retStr[c] = str.substring(c,c+1);
	}
	return retStr;
    }

    private static void addTo(String[][] loc, String[] array, int pos ) {
	for (int i = 0; i < array.length; i++) {
	    loc[pos][i] = array[i];
	}
    }

    public void create() {
	addTo(helpScreen, convertString( "Help Center:" ), 0);

	addTo(helpScreen, convertString( "Your goal is to reach the" ), 2 );
	addTo(helpScreen, convertString( "last corner of the last row in the maze" ), 3 );

	addTo(helpScreen, convertString( "Moving in the maze:" ), 5);
	addTo(helpScreen, convertString( "Enter w,a,s,d to move in the maze." ), 6);
	addTo(helpScreen, convertString( "The symbols on the map correspond to" ),8);
	addTo(helpScreen, convertString( "different items and monsters."), 9);



  
	addTo(helpScreen, convertString( "Using consumables: "),10);
	addTo(helpScreen, convertString( "Enter drink anywhere to use a consumable. " ),11);
	addTo(helpScreen, convertString( "Hp potions (type 1 to use) boosts" ), 12);
	addTo(helpScreen, convertString( "health while adrenaline (2) boosts speed." ), 13);
	
	addTo(helpScreen, convertString( "Attacking: "), 15);
	addTo(helpScreen, convertString( "Enter 1,2,3,4 to use the" ), 16);
	addTo(helpScreen, convertString( "corresponding attacks in battle." ), 17);

	addTo(helpScreen, convertString( "Enter 5 or run to run away" ), 18);
	addTo(helpScreen, convertString( "from battle (uses Luck)." ), 19);


	addTo(helpScreen, convertString( "Equipment: "), 21);
	addTo(helpScreen, convertString( "Enter settings in the maze." ), 22);
	addTo(helpScreen, convertString( "To check (type 3), equip (1), or unequip items (2)." ),23);
	addTo(helpScreen, convertString( "To change equipment, type the name"), 24);
	addTo(helpScreen, convertString( "of the equipment you want to equip/unequip."), 25);

	addTo(helpScreen, convertString( "Store: "),27);
	addTo(helpScreen, convertString( "Enter B (buy) or S (sell) and " ),28);
	addTo(helpScreen, convertString( "a number corresponding to the" ), 29);
	addTo(helpScreen, convertString( "item in shop screen. (ex: B1)" ),30);
	addTo(helpScreen, convertString( "Enter exit to exit the shop." ),31);


	addTo(helpScreen, convertString( "General:"), 33);
	addTo(helpScreen, convertString( "Hp = health" ), 34 );
	addTo(helpScreen, convertString( "Speed = chance for enemy to miss" ), 35 );
	addTo(helpScreen, convertString( "Damage = base damage dealth to enemy" ), 36 );
	addTo(helpScreen, convertString( "Luck = chance to escape" ), 37 );

	addTo(helpScreen, convertString( "If there is a back on the " ), 39);
	addTo(helpScreen, convertString( "bottom-left of the screen," ),40);
	addTo(helpScreen, convertString( "you can enter back to return" ),41);
	addTo(helpScreen, convertString( "to where you were." ),42);

	addTo(helpScreen, convertString( "Enter 'attacks' below to learn about each character's attacks." ),44);

	addTo(helpScreen, convertString( "Back" ),45);
    }

    public void showattackinfo() {
    	addTo(attackinfo, convertString( "Help Center:" ), 0);

    	addTo(attackinfo, convertString( "Tank Attacks:" ), 2);
    	addTo(attackinfo, convertString( "Swing: Does normal damage." ), 3);
    	addTo(attackinfo, convertString( "Shield Bash: Chance for extra damage" ), 4);
    	addTo(attackinfo, convertString( "and lowers enemy's speed." ), 5);
    	addTo(attackinfo, convertString( "Rampage: Deals more damage at the cost of speed."), 6);
    	addTo(attackinfo, convertString( "Charge: Chance to deal 0 - 2x the damage."), 7);

    	addTo(attackinfo, convertString( "Ninja Attacks:" ), 9);
    	addTo(attackinfo, convertString( "Munburedo (Moon Blade): Deals a bit extra damage." ), 10);
    	addTo(attackinfo, convertString( "Kyuketsuki (Vampire): Drains a bit of enemy's health."), 11);
    	addTo(attackinfo, convertString( "Surasshu (Slash): Deals normal damage and" ), 12);
    	addTo(attackinfo, convertString( "slightly increases speed." ), 13);
    	addTo(attackinfo, convertString( "Kangaeru (Meditate): Increases speed."), 14);

    	addTo(attackinfo, convertString( "DemoMan Attacks:" ), 16);
    	addTo(attackinfo, convertString( "Land Mine: Chance to deal a bit extra damage." ), 17);
    	addTo(attackinfo, convertString( "Explosive Surge: Increases damage."), 18);
    	addTo(attackinfo, convertString( "Impact Bomb: Deals direct, extra damage but" ), 19);
    	addTo(attackinfo, convertString( "decreases health." ), 20);
    	addTo(attackinfo, convertString( "Grenade: Normal damage and slightly increases speed."), 21);

    	addTo(attackinfo, convertString( "DankMeme Attacks:" ), 23);
    	addTo(attackinfo, convertString( "Mixtape: Chance to deal a extra damage." ), 24);
    	addTo(attackinfo, convertString( "Bling: Normal damage and slight speed increase."), 25);
    	addTo(attackinfo, convertString( "Learning Grammar: Increases speed." ), 26);
    	addTo(attackinfo, convertString( "Memes: Chance to deal great damage."), 27);

    	addTo(attackinfo, convertString( "Back" ),29);
    }
}
