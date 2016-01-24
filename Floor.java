public class Floor extends Tile {
    public Item item = new Item( "None", 0 );
    public Monster monster = new Monster(); // FLAG

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
	monster = genMonster();

	if ( hasMon() ) {
	    appearance = monster.toString();
	}
	else {
	    appearance = item.toString();
	}
    }

    public Floor(Item item, Monster monster) {
	this(item);
	this.monster = monster; //FLAG
	appearance = monster.toString();
    }

    private Monster genMonster() {
	if ( Math.random() < 1.0/8 ) {
	    return (new Snake());
	}
	
	else if( Math.random() < 1.0/7 ) {
	    return (new Orc());
	}

	else if( Math.random() < 1.0/8 ) {
	    return (new Rat());
	}

	else if( Math.random() < 1.0/6 ) {
	    return (new Boogeyman());
	}

	else if( Math.random() < 1.0/18) {
	    return (new JohnCena());
	} 

	return (new Monster());
    }

    public boolean hasMon() { //have monster and item
	return ((!monster.name.equals("NaBrO")) && (!item.name.equals("None")));
    }

    public String toString() {
	return super.toString();
    }

}
