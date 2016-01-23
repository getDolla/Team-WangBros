public class JohnCena extends Monster {
	public JohnCena() {
		super();
		hp = 700;
		speed = 15;
		damage = 70;

		name = "The Boss: Juan CenaporFavor";
		//stuff to add
		
		image = convertString(new String[] {
			" _____  ",
			"|_   _| ",
			"|.   .| ",
			"| <    )",
			"| __/)| ",
			"\\____ / "
		    });
		
	}

    public int attack(Character chara, BattleMap map) { //stuff to add
        return super.attack(chara,map);
    }
}
