public class Adrenaline extends Consumable {
    public boolean used;

    public Adrenaline() {
	super( "Adrenaline", 250 );
	boost = 5;
	used = false;
    }

    public String toString() {
	return "A";
    }

}
