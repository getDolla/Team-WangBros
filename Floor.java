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
	this.monster = monster;
	appearance = monster.toString();
    }

    private Monster genMonster() {
    double s = Engine.stage;

	if ( Math.random() < 1.0/(6.0 + 1.4*s) ) {
	    return (new Snake());
	}
	
	else if(( Math.random() < (1.0*s)/16.0) && ( s > 3 )) {
	    return (new JohnCena());
	} 

	else if( Math.random() < (0.6 *s)/6.0 ) {
	    return (new Orc());
	}

	else if( Math.random() < (0.6*s)/7.0 ) {
	    return (new Boogeyman());
	}

	else if( Math.random() < 1.0/(6.0 + 1.4*s) ) {
	    return (new Rat());
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
