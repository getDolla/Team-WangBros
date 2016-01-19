import java.util.ArrayList;

public class Character {
    public String name;

    public Floor appearance;

    protected int hp, speed, money, damage, luck;
    public int[] normalstats = new int[4];
    protected int[] location = { 1, 1 }; //initial start point
    public Floor tileUnder = new Floor();
    
    public boolean inBattle = false;

    public ArrayList<Armor> armors = new ArrayList<Armor>();
    public ArrayList<Weapon> sticks = new ArrayList<Weapon>();
    public ArrayList<Adrenaline> adren = new ArrayList<Adrenaline>();
    public ArrayList<HpPotion> healthdrinks = new ArrayList<HpPotion>();
    
    public Character() {
	appearance = new Floor( "*" );
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

    public void pickup( Item i ) {
        if ( i instanceof Weapon ) {
            sticks.add( (Weapon) i );
        }

        else if ( i instanceof Armor ) {
            armors.add( (Armor) i );
        }

        else if ( i instanceof Adrenaline ) {
            adren.add( (Adrenaline) i );
        }

        else if ( i instanceof HpPotion ) {
            healthdrinks.add( (HpPotion) i );
        }

        else {
            money += i.price;
        }
    }

    public void use( Item i ) {

	    if ( i instanceof Weapon ) {
		getBuff((Weapon)i);
	    }
	    else if ( i instanceof Armor ) {
		setCharstat((Armor)i);
	    }

	    else if ( i instanceof Adrenaline ) {
		drink((Consumable)i);
		adren.remove( (Adrenaline) i );
	    }
	    
	    else if ( i instanceof HpPotion ) {
		drink((Consumable)i);
		healthdrinks.remove( (HpPotion) i );
	    } 
    }
    
    public void setCharstat( Armor a ) {
	setHp( (int) (hp * a.equip()) );
	setSpeed( speed - a.debuff );
    }

    public int drink( Consumable i ) {
	if ( i instanceof HpPotion ) {
	    if( (hp + i.boost) < normalstats[0] ) {
    		setHp( hp + i.boost );
	    }
	    
	    else {
    		setHp( normalstats[0] ); 
	    }
	    
	    i.used = true;
	    return hp;
	}
	else if ( i instanceof Adrenaline ) {
	    
	    setSpeed( speed + i.boost );
	    i.used = true;
	    return speed;
	}
	return 0; //??
    }

    public int getBuff( Weapon i ) {
	setDamage( (int) (damage + i.equip()) );
	return damage;
    }

    public void displaystats() {
        System.out.print( "Health : " + hp + "\n" );
        System.out.print( "Speed : " + speed + "\n" );
        System.out.print( "Damage : " + damage + "\n" );
        System.out.print( "Luck : " + luck + "\n" );
    }
    
}
