public class Item {
    public String name;
    public int price;

    public Item( String s, int p ) { //mostly for money
	name = s;
	price = p;
    }

    public String toString() {
	return name;
    }

}
