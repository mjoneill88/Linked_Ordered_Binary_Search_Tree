import java.util.Iterator;

/**
 * Linked Binary Tree class. Abstract because there is no add or remove methods.  Designed as a starting template for continuation on a specific type of
 *   binary tree, such as heap, search, etc. Contains basic traversal methods and structure for a binary tree.
 *   
 * Implements: BinaryTreeADT<T>
 * 
 * @author Lewis and Chase and Lehmann
 * @version v1
 */
public abstract class LinkedBinaryTree<T> implements BinaryTreeADT<T> 
{

	/* Variables and Objects */
	
	protected int count;					// How many nodes are in the tree
	protected BinaryTreeNode<T> root;		// Root of the tree
	
	
	/**
	 * Constructor:
	 * sets count to 0 and root to null
	 */
	public LinkedBinaryTree() {
		count = 0;
		root = null;
	}
	
	/**
	 * Constructor:
	 * 	Sets count to 1 and sets root equal to the element sent in
	 * @param T element
	 */
	public LinkedBinaryTree(T element) {
		count = 1;
		root = new BinaryTreeNode<T>(element);
	}
	
	/**
	 * Constructor:
	 * 	Sets count equal to 1, and sets the roots left and right subtrees to the elements sent in
	 * @param T element
	 * @param LinkedBinaryTree<T> leftSubtree
	 * @param LinkedBinaryTree<T> rightSubtree
	 */
	public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree, LinkedBinaryTree<T> rightSubtree) {
		
		root = new BinaryTreeNode<T>(element);
		count = 1;
		if (leftSubtree != null) {
			count += leftSubtree.size();
			root.left = leftSubtree.root;
		}
		else
			root.left = null;
		
		if (rightSubtree != null) {
			count += rightSubtree.size();
			root.right = rightSubtree.root;
		}
		else
			root.right = null;
	}
	
	/**
	 * Removes the calling nodes left subtree and reduces count accordingly
	 */
	public void removeLeftSubtree() {
		if(root.left != null)
			count -= root.left.numChildren() + 1;
		root.left = null;
	}
	
	/**
	 * Removes the calling nodes right subtree and reduces count accordingly
	 */
	public void removeRightSubtree() {
		if(root.right != null)
			count -= root.right.numChildren() + 1;
		root.right = null;
	}
	
	/**
	 * Removes all elements of the tree.
	 * Sets count to zero and root to null
	 */
	public void removeAllElements() {
		count = 0;
		root = null;
	}
	
	/**
	 * Sends true if the tree is empty, false it it is full
	 * @return true if count is zero
	 */
	public boolean isEmpty() {
		
		return count == 0;
	}
	
	/**
	 * Returns the size of the tree as in Number of nodes
	 * @return int size of tree
	 */
	public int size() {
		
		return count;
	}
	
	/**
	 * Returns true if the specified element is in the Binary Tree
	 * @param T element to search for
	 * @return boolean true or false
	 */
	public boolean contains(T element) {
				
		@SuppressWarnings("unchecked")
		
		boolean found = false;
	
 		Iterator<T> it = iteratorInOrder();
		
 		while(it.hasNext() && !found) {
 			if(element.equals(it.next()) )
 				found = true;
		}
		
		return found;
	}
	
	/**
	 * Finds and returns the specified element
	 * @param T element to search for
	 * @return T the found element, or null if not found
	 */
	
	public T find (T element) {		
		
		@SuppressWarnings("unchecked")
		T lookingFor = null;
		
		boolean found = false;		
		Iterator<T> it = iteratorPreOrder();	
		
		while(it.hasNext() && !found) 
		{
			lookingFor = it.next( );
			if(element.equals(lookingFor) )
	        {
				    found = true;	
			}
			
		}
		
		return lookingFor;
	}
	
	/**
	 * Returns the in order version of the tree
	 * @return String, 10 elements per row, then a newline
	 */
	public String toString() {
		
		String tree = "";
		Iterator<T> it = iteratorInOrder();
		int count = 0;
		
		while (it.hasNext()) {
		        count++;
			if( (count % 10) != 0)
				tree += it.next() + " ";
			else 
				tree += it.next() + "\n";
		}
		
		return tree;
	}	
	
	/**
	 * Pre order traversal method.  Traverses Visit, Left, Right
	 * @param BinaryTreeNode<T> a node to be processed
	 * @param ArrayUnorderedList<T> list to store elements
	 */
	protected void preorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
		
		if (node != null) {
			templist.addToRear(node.element);		// Visit
			preorder (node.left, templist);			// Left			
			preorder(node.right, templist);			// Right
		}
	}
	
	/**
	 * In order traversal method.  Traverses Left, Visit, Right
	 * @param BinaryTreeNode<T> a node to be processed
	 * @param ArrayUnorderedList<T> list to store elements
	 */
	protected void inorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
		
		if (node != null) {
			inorder (node.left, templist);			// Left
			templist.addToRear(node.element);		// Visit		
			inorder(node.right, templist);			// Right
		}
	}

	/**
	 * Post order traversal method.  Traverses Left, Right, Visit
	 * @param BinaryTreeNode<T> a node to be processed
	 * @param ArrayUnorderedList<T> list to store elements
	 */
	protected void postorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
	
		if (node != null) {
			postorder (node.left, templist);			// Left		
			postorder(node.right, templist);			// Right
			templist.addToRear(node.element);			// Visit		
		}
	}	
	
	/**
	 * In order Iterator
	 * Traverses Visit, Left, Right
	 * @return Iterator<T> ArrayList Iterator
	 */
	public Iterator<T> iteratorPreOrder() {
		
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		preorder(root, templist);
		return templist.iterator();
	}
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 * @return Iterator<T> ArrayList Iterator
	 */
	public Iterator<T> iteratorInOrder() {
		
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		inorder(root, templist);
		return templist.iterator();
	}
	
	/**
	 * In order Iterator
	 * Traverses Left, Right, Visit
	 * @return Iterator<T> ArrayList Iterator
	 */
	public Iterator<T> iteratorPostOrder() {
		
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		postorder(root, templist);
		return templist.iterator();
	}
	
	/**
	 * Level order Iterator
	 * Traverses each level from left to right
	 * @return Iterator<T> ArrayList Iterator
	 */
	public Iterator<T> iteratorLevelOrder() {
		
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		LinkedQueue<BinaryTreeNode<T>> myq = new LinkedQueue<BinaryTreeNode<T>>();		
		BinaryTreeNode<T> current;
		
		myq.enqueue(root);
		
		while (!myq.isEmpty()) {
			
			current = myq.dequeue();
			
			if(current != null) {
				
				templist.addToRear(current.element);
				if(current.left != null)
					myq.enqueue(current.left);
				if(current.right != null)
					myq.enqueue(current.right);
			}
			else
				templist.addToRear(null);
		}
		
		return templist.iterator();
	}
}