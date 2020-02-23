/**
 * Interface for a Binary Search Tree
 * 
 * Extends BinaryTreeADT<T>
 * 
 * @author Lewis and Chase and Lehmann
 * 
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

	public void addElement(T element);
	
	public T removeElement(T element);
	
	public void removeAllOccurrences(T element);
	
	public T removeMin();
	
	public T removeMax();
	
	public T findMin();
	
	public T findMax();
	
}