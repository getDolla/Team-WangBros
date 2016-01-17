public class HpPotion extends Item {
    public int boost = 0;
    public boolean used;

    public HpPotion () {
	super( "HpPotion", 250 );
	boost = (int) ( Math.random() * 101 ) + 50;
	used = false;
    }

    public int drink( Character c ) {
    	if( (c.getHp() + boost) < c.normalstats[0] ) {
    		c.setHp( c.getHp() + boost );
    	}

    	else {
    		c.setHp( c.normalstats[0] ); 
    	}

    	used = true;
    	return c.getHp();
    }
}
