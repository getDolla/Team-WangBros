public class Wall extends Tile {
    
    private boolean isVertical;

    public Wall() {
	super();
	passable = false;
    }

    public Wall(boolean isVert) {
	this();
	if (isVert) {
	    super.appearance = "|";
	}
	else {
	    super.appearance = "-";
	}
    }

    public void interact(Character character) {
	//nothing
    }
    
}
