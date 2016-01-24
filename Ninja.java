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
	int temp = mon.lowerHealth(damage + (int)(damage * speed / 100.0));

	String s = attackNames[0];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
    }

    public String attack2( Monster mon, BattleMap map ) {
	int temp = mon.lowerHealth(damage); 
	int newHp = hp + (int)(damage/2.0);
	if (newHp <= normalstats[0]) {
	    hp = newHp;
	}
	else {
	    hp = 200;
	}
	
	String s = attackNames[0];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
	
    }

    public String attack3( Monster mon, BattleMap map ) {
	int temp = mon.lowerHealth(damage); 
	int newSpeed = (int) (speed * 1.05);
	String s = attackNames[2];
	if( temp == 0 ) {
		s += ", but missed.";
	}
	if (newSpeed <= normalstats[1] + 40 ) {
	    speed = newSpeed;
	}
	else {
	    speed = normalstats[1] + 40;
	}
	return s;
    }

    public String attack4( Monster mon, BattleMap map ) {
	int newSpeed = (int) (speed * 1.1);
	if (newSpeed <= normalstats[1] + 40) {
	    speed = newSpeed;
	}
	else {
	    speed = normalstats[1] + 40;
	}
	return attackNames[3];
    }

}
