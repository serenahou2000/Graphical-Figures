/**
 * This class represents nodes of the binary search tree
 * @author Serena Hou 251015235
 */

public class BinaryNode {
	
	private Pixel data;
	private BinaryNode left, right, parent;
	
	/* A constructor for the class. Stores the Pixel in the node and sets left 
	 * child, right child, and parent to the specified values.
	 */
	public BinaryNode (Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.data = value;
		this.setLeft(left);
		this.setRight(right);
		this.setParent(parent);
	}
		
	/* A constructor for the class that initializes a leaf node. The data, 
	 * children and parent are set to null
	 */
	public BinaryNode () {
		this.data = null;
		this.setLeft(null);
		this.setRight(null);
		this.setParent(null);
	}
		
	// Returns the parent of this node
	public BinaryNode getParent() {
		return this.parent;
	}
	
	// Sets the parent of this node to the specified value
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}
	
	// Sets the left child of this node to the specified value
	public void setLeft (BinaryNode p) {
		this.left = p;
	}
	
	// Sets the right child of this node to the specified value
	public void setRight (BinaryNode p) {
		this.right = p;
	}
	
	// Stores the given Pixel in this node
	public void setData (Pixel value) {
		this.data = value;
	}
	
	// Returns true if this node is a leaf; returns false otherwise
	public boolean isLeaf() {
		if (this.getLeft() == null && this.getRight() == null) {
			return true;
		}
		return false;
	}
	
	// Returns the Pixel object stored in this node
	public Pixel getData() {
		return this.data;
	}
	
	// Returns the left child of this node
	public BinaryNode getLeft() {
		return this.left;
	}
	
	// Returns the right child of this node
	public BinaryNode getRight() {
		return this.right;
	}
}
