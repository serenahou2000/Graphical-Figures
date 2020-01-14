/**
 * This class represents the position (x,y) of each pixel
 * @author Serena Hou 251015235
 */

public class Location {
	private int x, y;

	/* A constructor that initializes this Location object with the specified 
	 * coordinates
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Returns the x coordinate of this Location
	public int xCoord() {
		return x;
	}
	
	// Returns the y coordinate of this Location
	public int yCoord() {
		return y;
	}
	
	// Compares this Location with p using column order 
	public int compareTo (Location p) {
		if (x == p.xCoord() && y == p.yCoord()) {
			return 0;
		}
		else if (x < p.xCoord() || (x == p.xCoord() && y < p.yCoord())){
			return -1;
		}
		return 1;
	}
}
