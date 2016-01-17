public abstract class Item {
    public String name;
    public String appearance = "£";
    public int price;


    public Item() { //mostly for money
    }

    public String toString() {
		return appearance;
    }

}
