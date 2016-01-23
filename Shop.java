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
	addTo(shop,convertString(  "What would you like to buy?" ),1);
	addTo(shop,convertString( "Health potions: " + (new HpPotion()).price),2);
	addTo(shop,convertString( "Adrenaline: " + (new Adrenaline()).price),3);
	addTo(shop,convertString( "Light Armor: " + (new Light()).price),4);
	addTo(shop,convertString(  "Medium Armor: " + (new Medium()).price ),5);
	addTo(shop,convertString(  "Heavy Armor: " + (new Heavy()).price),6);
	addTo(shop,convertString(  "Twig: " + (new Twig()).price),7);
	addTo(shop,convertString(  "Sword: " + (new Sword()).price),8);
	for (int i = 0; i < shop.length; i++) {
	    shop[i][29] = "|";
	}


    }
}

    
