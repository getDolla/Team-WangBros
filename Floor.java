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
	if ( !this.item.name.equals( "None" ) ) {
	    this.monster = genMonster();
	}
	if ( hasMon() ) {
	    appearance = this.monster.toString();
	}
	else {
	appearance = item.toString();
	}
    }

    public Floor(Item item, Monster monster) {
	this(item);
	this.monster = monster; //FLAG
	appearance = item.toString();
    }

    private static Monster genMonster() {
	if ( Math.random() < 1.0/2 ) {
	    return (new Snake());
	}
	/*
	else if( Math.random() < 1.0/5 ) {
	    return (new Orc());
	}

	else if( Math.random() < 1.0/6 ) {
	    return (new Rat());
	}

	else if( Math.random() < 1.0/4 ) {
	    return (new Boogeyman());
	}

	else if( Math.random() < 1.0/15) {
	    return (new JohnCena());
	    } */

	return (new Monster());
    }

    public boolean hasMon() {
	return !this.monster.name.equals( "NaBro" );
    }

    public String toString() {
	return super.toString();
    }

}
