public class Snake extends Monster {

    
    public Snake() {
	super();
	hp = 50;
	speed = 20;
	damage = 15;
	name = "Snake";
	image = convertString( new String[]{" ______    ",
				"< .  . >   ",
				" \\ .. / |  ",
				"  \\__/| |  ",
				"  __|/ /   ",
				"  \\ ^ /____",
				"   \\______/"} );
	//stuff to add

    }

    public void attack(Character chara, BattleMap map) { //stuff to add
        chara.setHp(chara.getHp() - damage);
    }
}
