public class Wall extends Tile {
    
    private boolean isVertical;

    public Wall() {
	super();
	passable = false;
    }

    public Wall(boolean isVert) {
	this();
	if (isVert) {
	    appearance = "|";
	}
	else {
	    appearance = "-";
	}
    }

    public void interact(Character character) {
	//nothing
    }

    public String toString() {
	return super.toString();
    }
    
}
