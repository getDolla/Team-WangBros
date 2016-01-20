public class HpPotion extends Consumable {
    public int boost = 0;
    public boolean used;

    public HpPotion () {
	super( "HpPotion", 250 );
	boost = (int) ( Math.random() * 101 ) + 50;
	used = false;
    }

    public String toString () {
	return "+";
    }
}
