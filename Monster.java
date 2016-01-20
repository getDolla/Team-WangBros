public class Monster { 
    public String appearance, name;
    protected int hp, speed, damage;
    public String[][] image;

    public Monster() {
	if ( Math.random() * 10 < 3 ) {
	    appearance = " ";
	}

	else {
	    appearance = "ë"
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

    public int getMoney() {
	return money;
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

    public abstract int attack() {}

    public int lowerhealth( int hit ) {
	int temp = health;
	health -= hit;
	return temp;
    }
}
