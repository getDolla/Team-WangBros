public class Shop {
    public String[][] shop = new String[15][30];

    public Shop() {
	displayShop();
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

    public void displayShop() {
	addTo(shop,convertString( "You completed the maze!"),0);
	addTo(shop,convertString(  "Here are our items:" ),1);
	addTo(shop,convertString( "1.Health potion: " + (new HpPotion()).price),2);
	addTo(shop,convertString( "2.Adrenaline: " + (new Adrenaline()).price),3);
	addTo(shop,convertString( "3.Light Armor: " + (new Light()).price),4);
	addTo(shop,convertString(  "4.Medium Armor: " + (new Medium()).price ),5);
	addTo(shop,convertString(  "5.Heavy Armor: " + (new Heavy()).price),6);
	addTo(shop,convertString(  "6.Twig: " + (new Twig()).price),7);
	addTo(shop,convertString(  "7.Sword: " + (new Sword()).price),8);


    }
}

    
