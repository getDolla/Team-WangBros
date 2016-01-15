public abstract class Tile {
    
    public boolean passable;
    protected String appearance;

    public Tile() {};

    public abstract void interact(Character character);

    public String toString() {
	return appearance;
    }

}
