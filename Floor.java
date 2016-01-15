public class Floor extends Tile {
    private Item item;

    public Floor() {
	super();
	passable = true;
    }

    public Floor(Item item) {
	this();
	this.item = item; //change appearance
    }

    public void interact(Character character) {
	if (item != null) {
	    // Character.use item, when we get to item class
	}
	else { // probably else if
	}
	
    }

}
