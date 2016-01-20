public class Floor extends Tile {
    public Item item = new Item( "None", 0 );
    public Monster monster = new Monster(); // FLAG

    public Floor() {
	super();
	passable = true;
	appearance = " ";
	spawnRate = .25;
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
	this.monster = monster; //FLAG
	appearance = item.toString();
    }

    public boolean isMon() {
	return (Math.random() < spawnRate);
    }

    public String toString() {
	return super.toString();
    }

}
