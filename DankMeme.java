public class DankMeme extends Character {

    public DankMeme() {
	super();
	hp = 200;
	speed = 15;
	damage = 55;
	luck = 95;

	money = 0;

	normalstats[0] = hp;
	normalstats[1] = speed;
	normalstats[2] = damage;
	normalstats[3] = luck;
    }

    public DankMeme(String name) {
	this();
	this.name = name;
    }


    public void attack1( Monster mon, BattleMap map ){}
    public void attack2( Monster mon, BattleMap map ){}
    public void attack3( Monster mon, BattleMap map ){}
    public void attack4( Monster mon, BattleMap map ){}

}
