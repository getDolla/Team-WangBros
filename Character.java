import java.util.ArrayList;

public class Character {
    public String appearance,name;
    protected int hp, speed, money, damage, luck;
    public int[] normalstats = new int[4];
    protected int[] location = { 1, 1 }; //initial start point
    public Floor tileUnder = new Floor();

    public ArrayList armors = new ArrayList<Armor>();
    public ArrayList sticks = new ArrayList<Weapon>();
    public ArrayList adren = new ArrayList<Adrenaline>();
    public ArrayList healthdrinks = new ArrayList<HpPotion>();
    
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
            if ( i instanceof Twig ) {
                Twig w = (Twig) i;
            }

            else {
                Sword w = (Sword) i;
            }

            w.getBuff(this);
        }

        else if ( i instanceof Armor ) {
            if ( i instanceof Light ) {
                Light a = (Light) i;
            }

            else if ( i instanceof Medium ) {
                Medium a = (Medium) i;
            }

            else {
                Heavy a = (Heavy) i;
            }
                a.setCharstat( this );
        }

        else if ( i instanceof Adrenaline ) {
            ((Adrenaline) i).drink( this );
            adren.remove( (Adrenaline) i );
        }

        else if ( i instanceof HpPotion ) {
            ((HpPotion) i).drink( this );
            healthdrinks.remove( (HpPotion) i );
        } 
    }

}
