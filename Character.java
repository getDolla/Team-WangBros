public class Character {
    public String appearance,name;
    protected int hp, speed, money, damage, luck;
    public int[] normalstats = new int[4];
    protected int[] location = { 1, 1 }; //initial start point
    public Floor tileUnder = new Floor();

    public Character() {
	appearance = "*";
	name = "Bob";
    }
    
    public Character(String name) {
	this();
	this.name = name;
    }

    public String toString() {
	return "*";
    }

    public int getRLocation() {
	return location[0];
    }

    public int getCLocation() {
	return location[1];
    }
    
    public int setRLocation(int newVal) {
	int old = location[0];
	location[0] = newVal;
	return old;
    }
    
    public int setCLocation(int newVal) {
	int old = location[1];
	location[1] = newVal;
	return old;
    }

    // Accessors

    public int getHp() {
	return hp;
    }

    public int getSpeed() {
	return speed;
    }

    public int getMoney() {
	return money;
    }

    public int getDamage() {
	return damage;
    }

    public int getLuck() {
	return luck;
    }

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

    public int setMoney(int money) {
	int old = this.money;
	this.money = money;
	return old;
    }

    public int setDamage(int damage) {
	int old = this.damage;
	this.damage = damage;
	return old;
    }

    public int setLuck(int luck) {
	int old = this.luck;
	this.luck = luck;
	return old;
    }

    public void resetStats() {
        hp = normalstats[0];
        speed = normalstats[1];
        damage = normalstats[2];
        luck = normalstats[3];
    }

}
