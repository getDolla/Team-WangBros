public class Character {
    public String appearance,name;
    private int[] location = new int[2];

    public Character() {
	appearance = "*";
	name = "Bob";
	location[0] = 0;
	location[1] = 0;
    }
    
    public Character(String name) {
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

}
