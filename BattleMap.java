public class BattleMap {

    public String[][] map = new String[20][20];
    public Character character;
    public Monster monster;

    public BattleMap(Character character) {
	this.character = character;
    }

    public void show() {
	for (int c = 0; c < character.image.length; c++ ){
	    for (int i = 0; i < character.image[c].length; i++) {
		map[map[c].length - character.image.length + c][i] = character.image[c][i]; // To place in bottom left
	    }
	}
	

	for (int c = 0; c < monster.image.length; c++ ) {
	    for (int i = 0; i < monster.image[c].length; c++) {
		map[c][map.length - monster.image[c].length + i] = monster[c][i]; // Top Right
	    }
	}
    }
}
