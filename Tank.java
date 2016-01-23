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

	image = convertString(new String[] 
	    {	" _____ ",
	"/     \\",
	"|    ==",
	"\\_____/",
	"   |   ",
	" __|\\  ",
	"/  \\ + ",
	"|  | | ",
	"\\__/\\| "}
			      );

    }

    public Tank(String name) {
	this();
	this.name = name;
    }

    public String attack1( Monster mon, BattleMap map ){ return "nothing"; }
    public String attack2( Monster mon, BattleMap map ){ return "nothing"; }
    public String attack3( Monster mon, BattleMap map ){ return "nothing"; }
    public String attack4( Monster mon, BattleMap map ){ return "nothing"; }

}
