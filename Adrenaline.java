public class Adrenaline extends Consumable {
    public int boost = 0;
    public boolean used;

    public Adrenaline() {
	super( "Adrenaline", 250 );
	boost = 5;
	used = false;
    }

}
