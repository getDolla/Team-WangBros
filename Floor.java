public class Floor extends Tile {
    private Item item;

    public Floor() {
	super();
	passable = true;
	appearance = " ";
    }

    public Floor(Item item) {
	this();
	this.item = item;
	appearance = item.toString();
    }

    public void interact(Character character) {
	if (item != null) {
	    character.use(item);
	    item = null;
	    appearance = " ";
	}
    }

    public String toString() {
	return super.toString();
    }

}
