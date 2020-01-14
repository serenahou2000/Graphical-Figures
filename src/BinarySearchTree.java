/**
 * This class implements an ordered dictionary using a binary search tree
 * @author Serena Hou 251015235
 */

public class BinarySearchTree implements BinarySearchTreeADT{
	
	private BinaryNode root;
	
	// constructor
	public BinarySearchTree() {
		this.root = new BinaryNode();
	}
	
	private BinaryNode find (BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return r;
		}
		else if (key.compareTo(r.getData().getLocation()) == 0) {
			return r;
		}
		else if (key.compareTo(r.getData().getLocation()) == -1) {
			return find(r.getLeft(), key);
		}
		else {
			return find(r.getRight(), key);
		}
	}
	
	/* Returns the Pixel storing the given key, if the key is stored in the tree;
	 * returns null otherwise.(non-Javadoc)
	 * @see BinarySearchTreeADT#get(BinaryNode, Location)
	 */
	public Pixel get (BinaryNode r, Location key) {
		BinaryNode p = find(r, key);
		if (p.isLeaf()) {
			return null;
		}
		else {
			return p.getData();
		}
	}

	/* Inserts the given data in the tree if no data item with the same key is 
	 * already there. If a node already stores the same key, the algorithm throws a DuplicatedKeyException.(non-Javadoc)
	 * @see BinarySearchTreeADT#put(BinaryNode, Pixel)
	 */
	public void put (BinaryNode r, Pixel data) throws DuplicatedKeyException{
		BinaryNode p;
		p = find(r, data.getLocation());
		if (!p.isLeaf()) {
			throw new DuplicatedKeyException();
		}
		else {
			p.setData(data);
			BinaryNode left = new BinaryNode (null, null, null, p);
			BinaryNode right = new BinaryNode(null, null, null, p);
			p.setLeft(left);
			p.setRight(right);
		}
	}
	
	/* Removes the data item with the given key, if the key is stored in the tree; 
	 * throws an InexistentKeyException otherwise.(non-Javadoc)
	 * @see BinarySearchTreeADT#remove(BinaryNode, Location)
	 */
	public void remove (BinaryNode r, Location key) throws InexistentKeyException{
		BinaryNode p = find(r, key);
		BinaryNode left = p.getLeft();
		BinaryNode right = p.getRight();
		BinaryNode otherChild;
		
		if (p.isLeaf()) {
			throw new InexistentKeyException();
		}
		else if (left.isLeaf()) {
			BinaryNode parent = p.getParent();
			otherChild = right;
			if (p == root) {
				root = otherChild;
				otherChild.setParent(null);
			}
			else {
				if (parent.getRight() == p) {
					parent.setRight(otherChild);
					otherChild.setParent(parent);
				}
				else {
					parent.setLeft(otherChild);
					otherChild.setParent(parent);
				}
			}
		}
		else if (right.isLeaf()) {
			BinaryNode parent = p.getParent();
			otherChild = left;
			if (p == root) {
				root = otherChild;
				otherChild.setParent(null);
			}
			else {
				if (parent.getRight() == p) {
					parent.setRight(otherChild);
					otherChild.setParent(parent);
				}
				else {
					parent.setLeft(otherChild);
					otherChild.setParent(parent);
				}
			}
		}
		else {
			Pixel s = smallest(right);
			BinaryNode smallest = find(root, s.getLocation());
			p.setData(s);
			remove(smallest, s.getLocation());
		}
	}
	
	/* Returns the Pixel with the smallest key larger than the given one 
	 * (note that the tree does not need to store a node with the given key).
	 * Returns null if the given key has no successor.(non-Javadoc)
	 * @see BinarySearchTreeADT#successor(BinaryNode, Location)
	 */
	public Pixel successor (BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return null;
		}
		else {
			BinaryNode p = find(r, key);
			if (!p.isLeaf() && !p.getRight().isLeaf()) {
				return smallest(p.getRight());
			}
			else {
				BinaryNode parent = p.getParent();
				while (parent != r && p == parent.getRight()) {
					p = parent;
					parent = p.getParent();
				}
				if (p == r) {
					return null;
				}
				else {
					return parent.getData();
				}
			}
		}
	}
	
	/* Returns the Pixel with the largest key smaller than the given one 
	 * (note that the tree does not need to store a node with the given key).
	 * Returns null if the given key has no predecessor.(non-Javadoc)
	 * @see BinarySearchTreeADT#predecessor(BinaryNode, Location)
	 */
	public Pixel predecessor (BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return null;
		}
		else {
			BinaryNode p = find(r, key);
			if (!p.isLeaf() && !p.getLeft().isLeaf()) {
				return largest(p.getLeft());
			}
			else {
				BinaryNode parent = p.getParent();
				while (parent != r && p == parent.getLeft()) {
					p = parent;
					parent = p.getParent();
				}
				if (p == r) {
					return null;
				}
				else {
					return parent.getData();
				}
			}
		}
	}
	
	/* Returns the Pixel with the smallest key. Throws an EmptyTreeException 
	 * if the tree does not contain any data.(non-Javadoc)
	 * @see BinarySearchTreeADT#smallest(BinaryNode)
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		}
		else {
			BinaryNode p;
			p = r;
			while(!p.isLeaf()) {
				p = p.getLeft();
			}
			return p.getParent().getData();
		}
	}
	
	/* Returns the Pixel with the largest key. Throws an EmptyTreeException 
	 * if the tree does not contain any data.(non-Javadoc)
	 * @see BinarySearchTreeADT#largest(BinaryNode)
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		}
		else {
			BinaryNode p;
			p = r;
			while(!p.isLeaf()) {
				p = p.getRight();
			}
			return p.getParent().getData();
		}
	}
	
	// Returns the root of the binary search tree
	public BinaryNode getRoot() {
		return this.root;
	}
}
