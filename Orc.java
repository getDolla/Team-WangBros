public class Orc extends Monster {
    public Orc() {
	super();
	hp = 100;
	speed = 12;
	damage = 25;
		
	name = "Orc";
	//stuff to add
	image = convertString(new String[] {
		" __|__ ",
		"<.\\ /.>",
		"{^___^}",
		"|  |  |",
		"| /|\\ |",
		"+/ | \\+",
		"|  |  |",
		"  / \\  ",
		" /   \\ "
	    });
    }
    

    public int attack(Character chara, BattleMap map) { //stuff to add
	    return super.attack(chara,map);
    }

}
