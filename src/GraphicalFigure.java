/**
 * This class represents the graphical figures
 * @author Serena Hou 251015235
 */

public class GraphicalFigure implements GraphicalFigureADT{
	
	private int id, width, height;
	private String type;
	private Location pos;
	private BinarySearchTree tree = new BinarySearchTree();
	
	// Constructor
	public GraphicalFigure (int id, int width, int height, String type, Location pos) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
	}
	
	/*
	 * Returns the width of this figure
	 */
	public int getWidth() {
		return this.width;
	}

	/*
	 * Returns the height of this figure
	 */
	public int getHeight() {
		return this.height;
	}

	/*
	 * Returns the type of this figure
	 */
	public String getType() {
		return this.type;
	}

	/*
	 * Returns the id of this figure
	 */
	public int getId() {
		return this.id;
	}

	/*
	 * Returns the offset or position of this figure
	 */
	public Location getOffset() {
		return this.pos;
	}

	/*
	 * Changes the offset of this figure to the specified value.
	 */
	public void setOffset(Location value) {
		this.pos = value;
	}

	/*
	 * Change the type of this figure to the specified value.
	 */
	public void setType(String t) {
		this.type = t;
	}

	/*
	 * Adds the given Pixel object into the binary search tree associated with
	 * this figure. A DuplicatedKeyException is thrown if the figure already has
	 * a Pixel with the same key as pix.
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException{
		tree.put(tree.getRoot(), pix);
	}

	/*
	 * Returns true if this figure intersects the one specified in the
	 * parameter; it returns false otherwise.
	 */
	public boolean intersects(GraphicalFigure fig) {
		Pixel nextPix = tree.smallest(tree.getRoot());
		Pixel largestPix = tree.largest(tree.getRoot());
		while(nextPix != largestPix) {
			int xPrimeF = fig.getOffset().xCoord();
			int yPrimeF = fig.getOffset().yCoord();
			int xF = getOffset().xCoord();
			int yF = getOffset().yCoord();
			int x = nextPix.getLocation().xCoord();
			int y = nextPix.getLocation().yCoord();
			if(fig.findPixel(new Location((x + xF - xPrimeF), (y + yF - yPrimeF)))) {
				return true;
			}
			nextPix = tree.successor(tree.getRoot(), nextPix.getLocation());
		}
		return false;
	}
	
	private boolean findPixel(Location p) {
		if (tree.get(tree.getRoot(), p) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
