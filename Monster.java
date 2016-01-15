public abstract class Monster {
	public String appearance;
	protected int hp, speed, damage;
	public String[][] image;

	public Monster() {
		if ( Math.random() * 10 < 3 ) {
			appearance = " ";
		}

		else {
			appearance = "ë"
		}

		//stuff to add later
	}

	public String toString() {
		if( isDead() ) {
			appearance = " ";
		}

		return appearance;
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