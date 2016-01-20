public class Floor extends Tile {
    public Item item = new Item( "None", 0 );
    public Monster monster = new Monster();

    public Floor() {
	super();
	passable = true;
	appearance = " ";
    }

    public Floor( String s ) {
    	this();
    	appearance = s;
    }

    public Floor(Item item) {
	this();
	this.item = item;
	appearance = item.toString();
    }

    public Floor(Item item, Monster monster) {
	this(item);
	this.monster = monster;
	appearance = item.toString();
    }

    public void interact(Character character) {
	if (item != null) {
	    item = null;
	    appearance = " ";
	}
	if (Math.random() < spawnRate) {
	    character.inBattle = true;
	    character.enemy = new Snake();
	}
    }

    public String toString() {
	return super.toString();
    }

}
