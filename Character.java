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

    public boolean isShopping = false;

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
		//adren.remove( (Adrenaline) i );
	    }
	    
	    else if ( i instanceof HpPotion ) {
		drink((Consumable)i);
		//healthdrinks.remove( (HpPotion) i );
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
	    healthdrinks.remove( (HpPotion) i );
	    return hp;
	}
	else if ( i instanceof Adrenaline ) {
	    if (( speed + i.boost ) < 70 ) {
	    	setSpeed( speed + i.boost );
	    }

	    else {
	    	setSpeed( 70 );
	    }

	    i.used = true;
	    adren.remove( (Adrenaline) i );

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

    public boolean isMiss() {
        return (Math.random() < speed/100.0 );
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


    public void purchase(Item o) {
	if (money > o.price) {
	    money -= o.price;
	    if (o instanceof Light) {
		armors.add((Light) o); // Light is a subclass of Armor
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof Medium) {
		armors.add((Medium) o); 
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof Heavy) {
		armors.add((Heavy) o);
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof Twig) {
		sticks.add((Twig) o);
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof Sword) {
		sticks.add((Sword) o);
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof HpPotion) {
		healthdrinks.add((HpPotion) o);
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	    else if (o instanceof Adrenaline) {
		adren.add((Adrenaline) o);
		System.out.println("Successfully bought item for "+o.price+".");
	    }
	}
	else {
	    System.out.println("You do not have enough money.");
	}
	Engine.pressEnter();
    }

    public void sell(Item o) {
	boolean sold = false;
	int sellingPrice = ((int)(o.price*0.8));
	if (o instanceof Light) {
	    Light s = new Light();
	    for(int i = 0;i < armors.size(); i++) {
		if (armors.get(i) instanceof Light) {
		    s = (Light) armors.get(i);
		}
	    }
	    sold = armors.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof Medium) {
	    Medium s = new Medium();
	    for(int i = 0;i < armors.size(); i++) {
		if (armors.get(i) instanceof Medium) {
		    s = (Medium) armors.get(i);
		}
	    }
	    sold = armors.remove(s); 
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof Heavy) {
	    Heavy s = new Heavy();
	    for(int i = 0;i < armors.size(); i++) {
		if (armors.get(i) instanceof Heavy) {
		    s = (Heavy) armors.get(i);
		}
	    }
	    sold = armors.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof Twig) {
	    Twig s = new Twig();
	    for(int i = 0;i < sticks.size(); i++) {
		if (sticks.get(i) instanceof Twig) {
		    s = (Twig) sticks.get(i);
		}
	    }
	    sold = sticks.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof Sword) {
	    Sword s = new Sword();
	    for(int i = 0;i < sticks.size(); i++) {
		if (sticks.get(i) instanceof Sword) {
		    s = (Sword) sticks.get(i);
		}
	    }
	    sold = sticks.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof HpPotion) {
	    HpPotion s = new HpPotion();
	    for(int i = 0;i < healthdrinks.size(); i++) {
		if (healthdrinks.get(i) instanceof HpPotion) {
		    s = healthdrinks.get(i);
		}
	    }
	    sold = healthdrinks.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else if (o instanceof Adrenaline) {
	    Adrenaline s = new Adrenaline();
	    for(int i = 0;i < adren.size(); i++) {
		if (adren.get(i) instanceof Adrenaline) {
		    s = adren.get(i);
		}
	    }
	    sold = adren.remove(s);
	    if(sold) {
		money += sellingPrice;
		System.out.println("Successfully sold item for "+sellingPrice+".");
	    }
	}
	else {
	    System.out.println("You do not have enough money.");
	}
	Engine.pressEnter();
    }
    
}
