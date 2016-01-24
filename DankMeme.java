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

	image = convertString(new String[] 
	    {" ___   ",
	"|___|__",
	"|$   $|",
	"|__o__|",
	"   |   ",
	"  /|\\  ",
	"   |   ",
	"  / \\  "}
			      );

	attackNames = new String[] { "Mixtape","Bling","Learning Grammar","Memes" };

    }

    public DankMeme(String name) {
	this();
	this.name = name;
    }


    public String attack1( Monster mon, BattleMap map ){ 
    int temp = mon.lowerHealth(damage + (int)( (damage * luck * Math.random()) / 500.0));

	String s = attackNames[0];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
	}

    public String attack2( Monster mon, BattleMap map ){ 
   	int temp = mon.lowerHealth(damage);


	String s = attackNames[1];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
    }

    public String attack3( Monster mon, BattleMap map ){ 
    int newSpeed = (int) (this.getSpeed() * 1.075 );

    if (newSpeed <= 70) {
	    speed = newSpeed;
	}
	else {
	    speed = 70;
	}

	return attackNames[2];
    }

    public String attack4( Monster mon, BattleMap map ){
     int temp = mon.lowerHealth( (int) (damage * 0.5) + (int)( (damage * luck * Math.random()) / 250.0));

	String s = attackNames[3];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;  	
    }

}
