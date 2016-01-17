public class Weapon extends Equipment {
	public Weapon( String s, int p ) {
		super( s, p );
	}

	public int getBuff( Character c ) {
		c.setDamage( c.getDamage() + this.equip() );
		return c.getDamage();
	}
} 