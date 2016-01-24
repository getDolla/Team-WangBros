public class Equipment extends Item { 
	public double boost = 0;

	public Equipment( String s, int p ){
		super(s, p);
	}

	public double equip() {
		return boost;
	}

	public double unequip() {
		return 0;
	}

}

