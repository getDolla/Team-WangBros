public class Help {
    public String[][] helpScreen = new String[31][30];

    public Help() {
	create();
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

    private void create() {
	addTo(helpScreen, convertString( "Help Center:" ), 0);

	addTo(helpScreen, convertString( "Enter w,a,s,d to move in" ), 2);
	addTo(helpScreen, convertString( "the maze."),3);

	addTo(helpScreen, convertString( "Enter 1,2,3,4 to use the" ), 5);
	addTo(helpScreen, convertString( "corresponding attacks in" ), 6);
	addTo(helpScreen, convertString( "battle." ),7);

	addTo(helpScreen, convertString( "Enter 5 or run to run away" ), 9);
	addTo(helpScreen, convertString( "from battle." ), 10);

	addTo(helpScreen, convertString( "Enter drink anywhere to " ),12);
	addTo(helpScreen, convertString( "use a consumable." ), 13);

	addTo(helpScreen, convertString( "Enter settings in the maze" ), 15);
	addTo(helpScreen, convertString( "to equip or unequip items." ),16);

	addTo(helpScreen, convertString( "Enter B or S, followed by" ),18);
	addTo(helpScreen, convertString( "a number, to buy or sell in" ), 19);
	addTo(helpScreen, convertString( "shop screen." ),20);

	addTo(helpScreen, convertString( "Enter exit to exit the shop." ),22);

	addTo(helpScreen, convertString( "If there is a back on the " ),24);
	addTo(helpScreen, convertString( "bottom-left of the screen," ),25);
	addTo(helpScreen, convertString( "you can enter back to return" ),26);
	addTo(helpScreen, convertString( "to where you were." ),27);

	addTo(helpScreen, convertString( "Back" ),29);
    }
}
