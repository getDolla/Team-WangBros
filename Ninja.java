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
    }

    public Ninja(String name) {
	this();
	this.name = name;
    }
}
