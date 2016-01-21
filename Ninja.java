public class Ninja extends Character {


    public Ninja() {
	super();
	hp = 200;
	speed = 30;
	damage = 50;
	luck = 60;

	money = 0;

	normalstats[0] = hp;
	normalstats[1] = speed;
	normalstats[2] = damage;
	normalstats[3] = luck;

	image = convertString(new String[] 
	    {"_______",
	     "| - - |",
	     "\\__v__/",
	     "   |   ",
	     " /---\\ ",
	     "+  |   ",
	     "|  |   ",
	     "| / \\  "}
			      );

	attackNames = new String[] { "Munburedo","Kyuketsuki","Surasshu","Kangaeru" }; // Translation = Moon Blade, Vampire, Slash, Meditate

    }

    public Ninja(String name) {
	this();
	this.name = name;
    }

    public void attack1( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage + (int)(damage * speed / 100.0));
    }

    public void attack2( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage);
	hp += (int)(damage/2.0);
    }

    public void attack3( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage);
	speed = (int) (speed * 1.05);
    }

    public void attack4( Monster mon, BattleMap map ) {
	speed = (int) (speed * 1.1);
    }

}
