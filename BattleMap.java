public class BattleMap {

    public String[][] map = new String[20][20];
    public Character character;
    public Monster monster;


    public BattleMap(Character character, Monster monster) {
	this.character = character;
	this.monster = monster;
	create();
    }

    public void create() {
	for (int c = 0; c < character.image.length; c++ ){
	    for (int i = 0; i < character.image[0].length; i++) {
		map[map[c].length - character.image.length + c][i] = character.image[c][i]; // To place in bottom left
	    }
	}
	

	for (int c = 0; c < monster.image.length; c++ ) {
	    for (int i = 0; i < (monster.image[0]).length; i++) {
		map[c][(map[c].length) - (monster.image[0].length) + i] = monster.image[c][i]; // Top Right
	    }
	}
    }
}
