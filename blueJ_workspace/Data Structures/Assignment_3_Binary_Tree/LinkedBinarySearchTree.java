import java.util.Iterator;

/**
 * A Binary Search Tree implemented using nodes.  Class is designed for use with any generic data type (T). 
 * 
 * Extends LinkedBinaryTree<T>
 * Implements BinarySearchTreeADT<T>
 * 
 * @author Lewis and Chase and Lehmann
 * @version v1
 * 
 */
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

	
	/**
	 * Adds the specified element in its proper in order slot
	 * @param T element to be added to Binary Search Tree
	 */
	public void addElement(T element) {
		
		/* Variables and Objects */
		BinaryTreeNode<T> btn = new BinaryTreeNode<T>(element);		// Creates a new Binary Tree Node with the new element
		BinaryTreeNode<T> current;									// Creates a reference variable to a Binary Tree Node 
		boolean placed = false;
		
		// If the list is empty
		if (root == null) 
			root = btn;
		
		// If the list is not empty go here
		else {
			// Making a reference to root so as not to lose the tree
			current = root;
			
			// Type casting element to be of type comparable
			@SuppressWarnings("unchecked")
			Comparable<T> celement = (Comparable<T>)element;
			
			// While the element is not placed loop here
			while (!placed) {
				// If the element is less than current
				if (celement.compareTo(current.element) < 0) {
					// If currents left is null
					if (current.left == null) {
						current.left = btn;
						placed = true;
					}
					// If currents left is not null
					else 
						current = current.left;				
				}
				
				// If the element is greater than or equal to currents element
				else {
					// If currents right is null go here
					if (current.right == null) {
						current.right = btn;
						placed = true;
					}
					// If currents right is not null
					else
						current = current.right;
				}
			}			
		}
		// Increment count after adding the element
		count++;
	}
	
	/**
	 * Removes the specified element from the tree and returns it.  Reconnects tree around removed element to continue
	 * Binary tree order.
	 * @param T element to be removed
	 * @return T the element, if found
	 */	
	public T removeElement(T element) {
		
		/* Objects and Variables */
		BinaryTreeNode<T> current = root;					// Reference variable to the root, so as not to lose the tree
		BinaryTreeNode<T> parent = null;					// Reference variable to currents parent, to set left and right
		BinaryTreeNode<T> replace;							// The node that will replace the removed node
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;	// Type casting element to be of type comparable
		T remove = null;									// The element to be removed and returned, if found
		boolean found = false;
		
		// If the tree is empty
		if (root == null) {
			remove = null;
		}
		
		// If the tree is not empty
		else {
			
			// Loop until the element has been found, or until the tree has been searched through
			for (int i = 0; i < count && !found; i++) 
			{	
				// If the element being searched for is equal to current
				if (celement.compareTo(current.element) == 0) {
					found = true;
					remove = current.element;
					replace = replacement(current);
					
					// If the replacement node is null
					if (replace == null){
						// Find where current was, and set to null
						if (parent.left == current)							
							parent.left = null;
						else if (parent.right == current)							
							parent.right = null;					
						
						// Make current null
						current = null;						
					}
					
					// If replacement is another Binary Tree Node
					else {
						// Set currents element, left and right nodes to the new tree configuration
						current.element = replace.element;
						current.right = (replace.right);
						current.left = (replace.left);
					}
					// Decrement count
					count--;
				}
				
				// If the element being searched for is not equal to current
				else {
					// If it is less than current
					if (celement.compareTo(current.element) < 0) {
						parent = current;
						current = current.left;
					}
					// If it is greater than current
					else {
						parent = current;
						current = current.right;
					}
				}
			}
		}	
		// Return the element if found, will be null if not found
		return remove;
	}
	
	
	/**
     * Returns a reference to a node that will replace the one
     * specified for removal.  In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param BinaryTreenNode<T> -  the node to be removed
     * @return BinaryTreeNode<T> - a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) 
    {
    	/* Objects and Variables */
        BinaryTreeNode<T> result = null;
        
        
        // Four possible scenarios for finding a replacement
        //  1) The node has no children
        //  2) The node has only a left child
        //  3) The node has only a right child
        //  4) The node has two children
        
        // No children
        if ((node.left == null) && (node.right == null))
            result = null;
        // Only a right child
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        // Only a left child
        else if ((node.left == null) && (node.right != null))
            result = node.right;
        // Has both children
        else
        {
        	/* Variable and Objects */
            BinaryTreeNode<T> rcurrent = node.right;
            BinaryTreeNode<T> rparent = node;
            
            // While currents left is not null
            while (rcurrent.left != null)
            {
                rparent = rcurrent;
                rcurrent = rcurrent.left;
            }
            
            // Once the left most node has been found, sets the removed nodes left tree to the new replacement node
            rcurrent.left = node.left;
            
            // If nodes right child is not current
            if (node.right != rcurrent)
            {
                rparent.left = rcurrent.right;
                rcurrent.right = node.right;
            }
            
            // Set the node to do the replacing
            result = rcurrent;
        }
        // Return the node to replace the removed node
        return result;
    }
	
    /**
     * Removes all occurrences of a specified element
     * @param T - element to be removed
     */
	public void removeAllOccurrences(T element) {
		
		/* Objects and Variables */
		BinaryTreeNode<T> current = root;					// Node to enter the tree
		BinaryTreeNode<T> replace;							// The node to replace the removed node
		BinaryTreeNode<T> parent = null;					// Keeping track of the parent, to reconnect the tree after removal
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;	// Type casting the element to be of type Comparable
		
		boolean found = false;		
		
		// Loop until found or the end of the tree has been reached
		for (int i = 0; i < count && !found; i++) {
			
			// If the element is equal to currents element
			if (celement.compareTo(current.element) == 0) {
				
				// Flag the found variable as true, and find the node to replace the node that is getting removed
				found = true;				
				replace = replacement(current);
				
				// IF the node to do the replacing is null (No node)
				if (replace == null){
					// Find where current was, and set to null
					if (parent.left == current)							
						parent.left = null;
					else if (parent.right == current)							
						parent.right = null;					
					
					// Make current null
					current = null;						
				}
				
				// Reconfiguring the tree after the removal
				else {
					current.element = replace.element;
					current.right = (replace.right);
					current.left = (replace.left);
				}
				// Decrement count
				count--;
			}
			
			// If the element is not equal to currents element
			else {				
				// If the element searching for is less than currents element
				if (celement.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				// If it is greater than
				else {
					parent = current;
					current = current.right;
				}
			}
		}
		
		// See if the replacement node is another occurrence of the element you are trying to remove
		// If it is, call the method again
		if (celement.equals(current.element))
			removeAllOccurrences(element);
		
		
		if (!found)
			System.out.print("\nElement does not exist in tree.\n");
			
	}
	
	/**
	 * Removes and returns the minimum element
	 * 
	 * @return T - minimum element
	 */
	public T removeMin() {
		
		/* Variables and Objects */
		BinaryTreeNode<T> current = root;	// Node to enter the tree
		BinaryTreeNode<T> parent = null;	// Keeping track of the parent node to current
		BinaryTreeNode<T> replace;			// The node to replace the minimum node after removal
		T min;
		
		// If the current is not null, traverse the tree
		if (current.left != null) {
			parent = current;
			current = current.left;
		}
		parent = current;
		current = current.left;
		
		// Save the min element, find replacement
		min = current.element;
		replace = replacement(current);
		
		// If there is no replacement node
		if (replace == null){
			// Find where current was, and set to null
			if (parent.left == current)							
				parent.left = null;
			else if (parent.right == current)							
				parent.right = null;					
			
			// Make current null
			current = null;						
		}
		
		// Reconfigure the tree with the replacement
		else {
			current.element = replace.element;
			current.right = (replace.right);
			current.left = (replace.left);
		}
		
		// Return the min element
		return min;
	}
	
	/**
	 * Removes and returns the maximum element
	 * 
	 * @return T - maximum element
	 */
	public T removeMax() {
		
		/* Objects and Variables */
		BinaryTreeNode<T> current = root;	// Reference node to enter and traverse tree
		BinaryTreeNode<T> parent = null;	// Keep track of currents parent during traversal
		BinaryTreeNode<T> replace;			// Node for replacing max node
		T max;
		
		// Loop until 
		if (current.right != null) {
			parent = current;
			current = current.right;			
		}		
		parent = current;
		current = current.right;
		
		// Save and find replacement for the element
		max = current.element;
		replace = replacement(current);
		
		if (replace == null){
			// Find where current was, and set to null
			if (parent.left == current)							
				parent.left = null;
			else if (parent.right == current)							
				parent.right = null;					
			
			// Make current null
			current = null;						
		}	
		// If there is a replacement node, put it in its new location and patch the tree up around it
		else {
			current.element = replace.element;
			current.right = (replace.right);
			current.left = (replace.left);
		}
		
		return max;
	}
	
	public T findMin() {
		
		/* Variables and Objects */
		BinaryTreeNode<T> current = root;
		T min;
		
		// Try Catch block to prevent program from crashing
		try {
			// Find the farthest left element and save it
			if (current.left != null)
				current = current.left;
			current = current.left;
			min = current.element;
		}
		// Catch null exception to prevent tree from crashing
		catch (NullPointerException e) {
			System.out.print("Tree is empty");
			min = null;
		}	
		
		return min;		
	}
	
	/**
	 * Finds and returns the max value in the tree
	 * 
	 * @return T - The max element in the tree
	 */
	public T findMax() {
		
		/* Variables and Objects */
		BinaryTreeNode<T> current = root;
		T max;
		
		// Try catch block, so program doesn't crash if tree is empty
		try {
			// Loop until farthest right element is found then save it
			if (current.right != null)
				current = current.right;
			current = current.right;
			max = current.element;
		}
		// If tree is empty catch to prevent program from crashing
		catch (NullPointerException e) {
			System.out.print("Tree is empty");
			max = null;
		}
		
		return max;
	}
	
	/**
	 * Overrides the contains() method in LinkedBinaryTree to take advantage of the Search trees ordering
	 * @param T element to search for
	 * @return boolean true or false
	 */	
	public boolean contains(T element) {
				
		/* Variables and Objects */
		BinaryTreeNode<T> current = root;
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;
		boolean found = false;
		
		// If tree is empty
		if (current == null)
			System.out.print("\nTree is Empty\n");
		
		else {
			// Loop until the end of the tree has been reached or found
			while (current != null && !found) {
				if (celement.compareTo(current.element) == 0) {
					found = true;				
				}
				else {
					if (celement.compareTo(current.element) < 0) 
						current = current.left;
					else
						current = current.right;
				}
			}
		}
		
		return found;
	}
	
	/**
	 * Overrides the find() method in LinkedBinaryTree to take advantage of the Search trees ordering
	 * @param T element to search for
	 * @return T the found element, or null if not found
	 */	
	public T find (T element) {		
		
		/* Objects and Variables */
		BinaryTreeNode<T> current = root;
		@SuppressWarnings("unchecked")
		Comparable<T> celement = (Comparable<T>)element;
		boolean found = false;
		T lookingFor = null;
		
		// If tree is empty
		if (current == null)
			System.out.print("\nTree is Empty\n");
		
		else {
			// Loop until the end of the tree has been reached or found
			while (current != null && !found) {
				if (celement.compareTo(current.element) == 0) {
					found = true;
					lookingFor = current.element;
				}
				else {
					if (celement.compareTo(current.element) < 0) 
						current = current.left;
					else
						current = current.right;
				}
			}
		}
				
		return lookingFor;
	}	
}
