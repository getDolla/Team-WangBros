public class DemoMan extends Character {
    public DemoMan() {
	super();
	hp = 300;
	speed = 15;
	damage = 100;
	luck = 60;

	money = 0;

	normalstats[0] = hp;
	normalstats[1] = speed;
	normalstats[2] = damage;
	normalstats[3] = luck;
    }

    public DemoMan(String name) {
	this();
	this.name = name;
    }


    public void attack1( Monster mon, BattleMap map ){}
    public void attack2( Monster mon, BattleMap map ){}
    public void attack3( Monster mon, BattleMap map ){}
    public void attack4( Monster mon, BattleMap map ){}

}
