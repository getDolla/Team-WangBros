public class Item {
    public String name;
    public String appearance = "&";
    public int price;


    public Item() { 
    }

    public Item(String name, int price) { //mostly for money
	this.name = name;
	this.price = price;
    }

    public String toString() {
		return appearance;
    }

}
