public class Ninja extends Character {


    public Ninja() {
	super();
	hp = 250;
	speed = 30;
	damage = 52;
	luck = 60;

	money = 0;

	normalstats[0] = hp;
	normalstats[1] = speed;
	normalstats[2] = damage;
	normalstats[3] = luck;

	image = convertString(new String[] 
	    {"_______",
	     "| - - |",
	     "\\__-__/",
	     "   |   ",
	     " /---\\ ",
	     "+  |   ",
	     "|  |   ",
	     "| / \\  "}
			      );

	attackNames = new String[] { "Munburedo (Moon Blade)","Kyuketsuki (Vampire)","Surasshu (Slash)","Kangaeru (Meditate)" }; // Translation = Moon Blade, Vampire, Slash, Meditate

    }

    public Ninja(String name) {
	this();
	this.name = name;
    }

    public String attack1( Monster mon, BattleMap map ) {
	int temp = mon.lowerHealth(damage + (int)(damage * speed / 120.0));

	String s = attackNames[0];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
    }

    public String attack2( Monster mon, BattleMap map ) {
	int temp = mon.lowerHealth(damage); 
	int newHp = hp + (int)(damage/3.0);
	if (newHp < normalstats[0]) {
	    hp = newHp;
	}
	else {
	    hp = normalstats[0];
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
	if (newSpeed < normalstats[1] + 30 ) {
	    speed = newSpeed;
	}
	else {
	    speed = normalstats[1] + 30;
	}
	return s;
    }

    public String attack4( Monster mon, BattleMap map ) {
	int newSpeed = (int) (speed * 1.15);
	if (newSpeed < normalstats[1] + 30) {
	    speed = newSpeed;
	}
	else {
	    speed = normalstats[1] + 30;
	}
	return attackNames[3];
    }

}
