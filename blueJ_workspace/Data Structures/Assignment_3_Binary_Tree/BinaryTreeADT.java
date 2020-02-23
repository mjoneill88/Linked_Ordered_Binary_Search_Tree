import java.util.ArrayList;
import java.util.Iterator;

/**
 * Interface for a generic Binary Tree.
 * 
 * @author  Lewis and Chase and Lehmann
 * @version v1
 *
 */

public interface BinaryTreeADT<T> {	
	
	/**
	 * Removes the calling nodes left subtree and reduces count accordingly
	 */
	public void removeLeftSubtree(); 
	
	/**
	 * Removes the calling nodes right subtree and reduces count accordingly
	 */
	//public void removeRightSubtre();
	
	/**
	 * Removes all elements of the tree.
	 * Sets count to zero and root to null
	 */
	public void removeAllElements();
	
	/**
	 * Sends true if the tree is empty, false it it is full
	 * @return true if count is zero
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the size of the tree as in Number of nodes
	 */
	public int size();
	
	/**
	 * Returns true if the element is in the tree
	 * @param T - element to search for
	 * @return boolean
	 */
	public boolean contains(T element);
	
	/**
	 * Searches for an element in the tree
	 * @param T - element to search for
	 * @return T - element if found
	 */
	public T find (T element);
	
	/**
	 * To string
	 * @return String - representation of the tree
	 */
	public String toString();	
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 */
	public Iterator<T> iteratorPreOrder();
	
	/**
	 * In order Iterator
	 * Traverses Left, Visit, Right
	 */
	public Iterator<T> iteratorInOrder();
	
	/**
	 * In order Iterator
	 * Traverses Left, Right, Visit
	 */
	public Iterator<T> iteratorPostOrder();
	
	/**
	 * Level order Iterator
	 */
	public Iterator<T> iteratorLevelOrder();
}
