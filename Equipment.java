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

