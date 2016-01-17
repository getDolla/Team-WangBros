public class Equipment extends Item { 
	public int boost = 0;
	public boolean equipped = false;

	public Equipment( String s, int p ){
		super(s, p);
	}

	public int equip() {
		equipped = true;
		return boost;
	}

	public int unequip() {
		equipped = false;
		return 0;
	}

}