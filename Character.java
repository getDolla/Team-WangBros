import java.util.ArrayList;

public abstract class Character {
    public String name;

    public Floor appearance; // Outside of battle
    public String[][] image; // For battle

    protected int hp, speed, money, damage, luck;
    public int[] normalstats = new int[4];
    protected int[] location = { 1, 1 }; //initial start point
    public Floor tileUnder = new Floor();
    
    public boolean inBattle = false;
    public Monster enemy = null;

    public ArrayList<Armor> armors = new ArrayList<Armor>();
    public ArrayList<Weapon> sticks = new ArrayList<Weapon>();
    public ArrayList<Adrenaline> adren = new ArrayList<Adrenaline>();
    public ArrayList<HpPotion> healthdrinks = new ArrayList<HpPotion>();

    public String[] attackNames= new String[4];
    
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
    /*
    public void attack( Object mon) {
	Monster monster;
	if (mon instanceof Object){
	    monster = (Monster) mon;
	}
	else {
	    throw new ClassCastException("\n Error L203"); // DEBUGGING
	}
	if ( Math.random() * monster.speed < 45 ) {
	    monster.setHp( monster.getHp() - ( damage ) );
	}
    }
    */
    //FLAG - PROBABLY SHOULD BE IN SUBCLASSES

    // Feel free to make first parameter Object and try to catch errors
    public abstract String attack1( Monster mon, BattleMap map );
    public abstract String attack2( Monster mon, BattleMap map );
    public abstract String attack3( Monster mon, BattleMap map );
    public abstract String attack4( Monster mon, BattleMap map );
    

    protected static String[][] convertString( String[] array ) { // to make image
	String[][] retStr = new String[array.length][array[0].length()];
	for (int c = 0; c < retStr.length; c ++) {
	    for (int i = 0; i < retStr[c].length; i++) {
		retStr[c][i] = array[c].substring(i,i+1);
	    }
	}
	return retStr;
    }

    public void printAttacks(){
	for (int i = 0; i < attackNames.length; i++) {//safer measure is i < 4
	    System.out.println((i+1) + ":" + attackNames[i] + "\t");
	}
    }
    
}
