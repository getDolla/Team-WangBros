<<<<<<< HEAD
public class Equipment extends Items {
    protected int boost;
    public Equipment( String s, int p ) {
	super( name );
	boost = 0;
    }

    public int equip(Character c) {
	
	return boost;
    }









}
=======
public class Equipment extends Item { 
	public double boost = 0;
	public boolean equipped = false;

	public Equipment( String s, int p ){
		super(s, p);
	}

	public double equip() {
		equipped = true;
		return boost;
	}

	public double unequip() {
		equipped = false;
		return 0;
	}

}
>>>>>>> 2a128f592441d71fcde36ad30bc757ed421dca95
