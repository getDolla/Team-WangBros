public class Tank extends Character{
    public Tank() {
	super();
	hp = 500;
	speed = 10;
	damage = 85;
	luck = 60;

	money = 0;

	normalstats[0] = hp;
	normalstats[1] = speed;
	normalstats[2] = damage;
	normalstats[3] = luck;

	image = convertString(new String[] 
	    {	" _____ ",
	"/     \\",
	"|    ==",
	"\\_____/",
	"   |   ",
	" __|\\  ",
	"/  \\ + ",
	"|  | | ",
	"\\__/\\| "}
			      );

	attackNames = new String[]{ "Swing","Shield Bash","Rampage","Charge"};

    }

    public Tank(String name) {
	this();
	this.name = name;
    }

    public String attack1( Monster mon, BattleMap map ){ 
    	int temp = mon.lowerHealth(damage);

		String s = attackNames[0];
		if(temp == 0) {
	    	s += ", but missed.";
		}
		return s;
    }

    public String attack2( Monster mon, BattleMap map ){ 
    int temp = mon.lowerHealth( (int ) ( damage + (0.4 * damage * Math.random()) )) ;

	String s = attackNames[1];
	if(!(temp == 0)) {
<<<<<<< HEAD
	    mon.setSpeed( 2 );
=======
		mon.setSpeed( 2 );
>>>>>>> 322f62b7ad2563e6dc8def0b0b7e4a083c3be6c8
	    return s;
	}

	s += ", but missed.";
	return s;
	}

    public String attack3( Monster mon, BattleMap map ){ 
<<<<<<< HEAD
    	int temp = mon.lowerHealth( (int) (damage + ( damage * ( Math.random() + 0.5 ))) );
=======
    	int temp = mon.lowerHealth( (int) (damage + ( damage * ( Math.random() + 0.5 ) )));
>>>>>>> 322f62b7ad2563e6dc8def0b0b7e4a083c3be6c8
    	this.setSpeed( this.getSpeed() - 1 );

    	String s = attackNames[2];
		if(temp == 0) {
	    	s += ", but missed.";
		}
		return s;
    }
    
    public String attack4( Monster mon, BattleMap map ){ 
    	int temp = mon.lowerHealth( (int) (damage * 2 * Math.random()) );

    	String s = attackNames[3];
	if(temp == 0) {
	    	s += ", but missed.";
		}
		return s;
    }

}
