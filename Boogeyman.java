public class Boogeyman extends Monster {
	public Boogeyman() {
		super();
		hp = 200;
		speed = 5;
		damage = 50;

		name = "Boogeyman";

		//stuff to add
		image = convertString(new String[]{
			"  ____  ",
			" (o  O) ",
			"  |^ |  ",
			"  |==|_ ",
			"/\\ /\\  )",
			"  \\  \\ |",
			"  |  | |",
			"  __/__/"});
		
	}

    public int attack(Character chara, BattleMap map) { //stuff to add
        return super.attack(chara,map);
    }
}
