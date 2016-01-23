public class Floor extends Tile {
    public Item item = new Item( "None", 0 );
    public Monster monster = genMonster(); // FLAG

    public Floor() {
	super();
	passable = true;
	appearance = " ";
    }

    public Floor( String s ) {
    	this();
    	appearance = s;
	monster = genMonster();
    }

    public Floor(Item item) {
	this();
	this.item = item;

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
	appearance = item.toString();
    }

    private Monster genMonster() {
	if ( Math.random() < 1.0/6 ) {
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
	monster = genMonster();
	return (!monster.name.equals("NaBrO"));
    }

    public String toString() {
	return super.toString();
    }

}
