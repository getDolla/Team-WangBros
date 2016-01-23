public class Rat extends Monster {
	public Rat() {
		super();
		hp = 20;
		speed = 7;
		damage = 7;

		name = "Rat";
		//stuff to add
		image = convertString(new String[] {
			" (\\_/) ",
			"(o o ) ",
			"=<== \\ ",
			" / /( )",
			"  _| _|"
		    });

	}

    public int attack(Character chara, BattleMap map) { //stuff to add
        return super.attack(chara,map);
    }
}
