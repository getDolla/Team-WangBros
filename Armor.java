public class Armor extends Equipment {
	public int debuff;

	public Armor( String s, int p ) {
		super( s, p );
	}

	public void setCharstat( Character c ) {
		c.setHp( c.getHp() * this.equip() );
		c.setSpeed( c.getSpeed() - debuff );
	}
}