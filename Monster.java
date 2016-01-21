public class Monster { 
    public String appearance, name;
    protected int hp, speed, damage;
    public String[][] image;

    public Monster() {
	if ( Math.random() * 10 < 3 ) {
	    appearance = " ";
	}

	else {
	    appearance = "ë";
		}

	name = "NaBrO";

	//stuff to add later
    }

    public String toString() {
	if( isDead() ) {
	    appearance = " ";
	}

	return appearance;
    }

    // accessors

    public int getHp() {
	return hp;
    }

    public int getSpeed() {
	return speed;
    }

    public int getDamage() {
	return damage;
    }

    public String getName() {
	return name;
    }

    // mutators

    public int setHp(int hp) {
	int old = this.hp;
	this.hp = hp;
	return old;
    }

    public int setSpeed(int speed) {
	int old = this.speed;
	this.speed = speed;
	return old;
    }
    public int setDamage(int damage) {
	int old = this.damage;
	this.damage = damage;
	return old;
    }


    public boolean isDead() {
	return ( hp <= 0 );
    }

    public void attack( Character chara, BattleMap map )
    {} // FLAG - IN CASE WE WANT TO MAKE THIS ABSTRACT

    public int lowerHealth( int hit ) {
	int temp = hp;
	hp -= hit;
	return temp;
    }

    protected static String[][] convertString( String[] array ) { //to make image
	String[][] retStr = new String[array.length][array[0].length()];
	for (int c = 0; c < retStr.length; c ++) {
	    for (int i = 0; i < retStr[c].length; i++) {
		retStr[c][i] = array[c].substring(i,i+1);
	    }
	}
	return retStr;
    }
}
