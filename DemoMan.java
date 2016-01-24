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
	
	image = convertString(new String[] 
	    { 
	" o  __ ",
	"/|\\<::>",
	" | <__>",
	"/ \\    "}
			      );
	
	attackNames = new String[]{ "Land Mine","Explosive Surge","Impact Bomb","Grenade"};

    }

    public DemoMan(String name) {
	this();
	this.name = name;
    }


    public String attack1( Monster mon, BattleMap map ){ 
	int temp = 0;
	if (Math.random() * luck > 25) {
	    temp = mon.lowerHealthD((int)(damage*1.4));
	}
	
	String s = attackNames[0];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
    }

    public String attack2( Monster mon, BattleMap map ){
	int newDamage = ((int)(damage + (damage * (( Math.random() * luck / 3000.0)))));
	if (newDamage < 250) {
	    damage = newDamage;
	}
	else {
	    damage = 250;
	}
	String s = attackNames[1];
	return s;
    }

    public String attack3( Monster mon, BattleMap map ){
	int temp = 0;
	hp = ((int)(hp* 0.9));
	temp = mon.lowerHealthD((int)(damage*1.3));
	
	String s = attackNames[2];

	if( temp == 0 ) {
		s += ", but missed.";
	}

	return s;
    }

    public String attack4( Monster mon, BattleMap map ){
    int temp = mon.lowerHealth(damage);

	String s = attackNames[3];
	if(temp == 0) {
	    s += ", but missed.";
	}
	return s;
    }

}
