public abstract class Item {
    public String name;
    public String appearance = "&";
    public int price;


    public Item() { //mostly for money
    }

    public Item(String name, int price) {
	this.name = name;
	this.price = price;
    }

    public String toString() {
		return appearance;
    }

}
