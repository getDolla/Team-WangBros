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
    }

    public Tank(String name) {
	this()
	this.name = name;
    }
}
