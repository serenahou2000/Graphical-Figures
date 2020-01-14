/**
 * This class represents the data items to be stored in the binary search tree
 * @author Serena Hou 251015235
 */
public class Pixel {
	
	private Location key;
	private int color;
	
	/* A constructor which initializes the new Pixel with the specified coordinates 
	 * and color. Location p is the key for the Pixel
	 */
	public Pixel(Location p, int color) {
		this.key = p;
		this.color = color;
	}
	
	// Returns the Location of the Pixel
	public Location getLocation() {
		return this.key;
	}
	
	// Returns the color of the Pixel
	public int getColor() {
		return this.color;
	}
}
