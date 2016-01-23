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

    public String attack1( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage + (int)(damage * speed / 100.0));
	return attackNames[0];
    }

    public String attack2( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage); 
	int newHp = hp + (int)(damage/2.0);
	if (newHp <= normalstats[0]) {
	    hp = newHp;
	}
	else {
	    hp = 200;
	}
	return attackNames[1];
    }

    public String attack3( Monster mon, BattleMap map ) {
	mon.lowerHealth(damage);
	int newSpeed = (int) (speed * 1.05);
	if (newSpeed <= 60) {
	    speed = newSpeed;
	}
	else {
	    speed = 60;
	}
	return attackNames[2];
    }

    public String attack4( Monster mon, BattleMap map ) {
	int newSpeed = (int) (speed * 1.1);
	if (newSpeed <= 60) {
	    speed = newSpeed;
	}
	else {
	    speed = 60;
	}
	return attackNames[3];
    }

}
