public abstract class Tile {
    
    public boolean passable;
    protected String appearance;
    protected double spawnRate;

    public Tile() {
	spawnRate = .10;
    }

    public String toString() {
	return appearance;
    }

}
