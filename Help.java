public class Help {
    public String[][] helpScreen = new String[44][60];
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

	addTo(helpScreen, convertString( "Enter w,a,s,d to move in" ), 2);
	addTo(helpScreen, convertString( "the maze."),3);

	addTo(helpScreen, convertString( "Enter 1,2,3,4 to use the" ), 5);
	addTo(helpScreen, convertString( "corresponding attacks in" ), 6);
	addTo(helpScreen, convertString( "battle." ),7);

	addTo(helpScreen, convertString( "Enter 5 or run to run away" ), 9);
	addTo(helpScreen, convertString( "from battle (uses Luck)." ), 10);

	addTo(helpScreen, convertString( "Enter drink anywhere to " ),12);
	addTo(helpScreen, convertString( "use a consumable. Hp potions boosts" ), 13);
	addTo(helpScreen, convertString( "health while adrenaline boosts speed." ), 14);

	addTo(helpScreen, convertString( "Enter settings in the maze" ), 16);
	addTo(helpScreen, convertString( "to check (type 3), equip (1), or unequip items (2)." ),18);
	addTo(helpScreen, convertString( "To change equipment, type the name"), 19);
	addTo(helpScreen, convertString( "of the equipment you want to equip/unequip."), 20);

	addTo(helpScreen, convertString( "Enter B (buy) or S (sell) and " ),22);
	addTo(helpScreen, convertString( "a number corresponding to the" ), 23);
	addTo(helpScreen, convertString( "item in shop screen. (ex: B1)" ),24);
	addTo(helpScreen, convertString( "Enter exit to exit the shop." ),25);

	addTo(helpScreen, convertString( "Your goal is to reach the" ), 27 );
	addTo(helpScreen, convertString( "last corner of the last row in" ), 28 );
	addTo(helpScreen, convertString( "the maze." ), 29 );

	addTo(helpScreen, convertString( "Hp = health" ), 31 );
	addTo(helpScreen, convertString( "Speed = chance for enemy to miss" ), 32 );
	addTo(helpScreen, convertString( "Damage = base damage dealth to enemy" ), 33 );
	addTo(helpScreen, convertString( "Luck = chance to escape" ), 34 );

	addTo(helpScreen, convertString( "If there is a back on the " ), 36);
	addTo(helpScreen, convertString( "bottom-left of the screen," ),37);
	addTo(helpScreen, convertString( "you can enter back to return" ),38);
	addTo(helpScreen, convertString( "to where you were." ),39);

	addTo(helpScreen, convertString( "Enter attacks below to learn about each character's attacks." ),41);

	addTo(helpScreen, convertString( "Back" ),43);
    }

    public void showattackinfo() {
    	addTo(attackinfo, convertString( "Help Center:" ), 0);

    	addTo(attackinfo, convertString( "Tank Attacks:" ), 2);
    	addTo(attackinfo, convertString( "Swing: Does normal damage." ), 3);
    	addTo(attackinfo, convertString( "Shield Bash: Chance for extra damage" ), 4);
    	addTo(attackinfo, convertString( "and lowers enemy's speed." ), 5);
    	addTo(attackinfo, convertString( "Rampage: Deals more damage are the cost of speed."), 6);
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
