public class HpPotion extends Consumable {
    public boolean used;

    public HpPotion () {
	super( "HpPotion", 250 );
	boost = (int) ( Math.random() * 50 ) + 50;
	used = false;
    }

    public String toString () {
	return "+";
    }
}
