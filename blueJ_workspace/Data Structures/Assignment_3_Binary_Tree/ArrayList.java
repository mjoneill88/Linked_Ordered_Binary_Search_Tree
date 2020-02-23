import java.util.Iterator;

/**
 * Array List code designed for generic types.  Code can be reused with any object and the user won't know the difference.
 * Class is abstract and does not contain an add method.  The user must extend this code and write an add method for 
 * either an ordered or an unordered list.
 * 
 * Implements: ListADT<T> list interface to comply with Java list standards
 * 
 * @author Lewis and Chase and Lehmann
 * @version v1
 *
 */

public abstract class ArrayList<T> implements ListADT<T> {

	
	/* Objects and Variables */
	protected final int DEFAULT_SIZE = 100;
	protected T list[];
	protected int rear;
	
	/**
	 * Constructor:
	 * Creates a new list of size 100 type casted to be of the generic type T
	 * sets rear equal to 0
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		list = (T[])new Object[DEFAULT_SIZE];
		for(int i = 0; i < list.length; i++) {
			list[i] = (T)new Object();
		}
		rear = 0;
	}
	
	/**
	 * Constructor:
	 * Creates a new list type casted to be of type T (generic) of the user specified size,
	 * sets the rear equal to 0
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		list = (T[])new Object[size];
		for(int i = 0; i < list.length; i++) {
			list[i] = (T)new Object();
		}
		rear = 0;
	}
	
	/**  
     * Removes and returns the first element from this list. 
     * 
     * @return the first element from this list
     */
    public T removeFirst() throws EmptyCollectionException {
    	
    	T result;
    	if(rear == 0) 
    		throw new EmptyCollectionException("List is Empty");
    	result = list[0];
    	for (int i = 0; i < list.length -1; i++) {
    		list[i] = list[i + 1];
    	}
    	rear--;
    	return result;
    }

    /**  
     * Removes and returns the last element from this list. 
     *
     * @return the last element from this list
     */
    public T removeLast() throws EmptyCollectionException {
    	
    	T result;
    	if (rear == 0)
    		throw new EmptyCollectionException("List is Empty");
    	else 
    		result = list[--rear];    	
    
    	return result;
    }

    /**  
     * Removes and returns the specified element from this list. 
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollectionException {
    	
    	T result = null;
    	if (rear == 0)
    		throw new EmptyCollectionException("List is Empty");
    	boolean found = false;
    	for (int i = 0; i < (list.length - 1) && !found; i++) {
    		if (list[i].equals(element)) {
    			found = true;
    			result = list[i];
    			for (int k = i; k < ((list.length - 1) - i); k++) {
    				list[k] = list[k + 1];
    			}    			
    		}
    	}
    	rear--;
    	
    	return result;
    }

    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     */
    public T first() {
    	
    	if (rear == 0) {
    		throw new EmptyCollectionException("List is Empty.");
    	}
    	return list[0];
    }

    /**  
     * Returns a reference to the last element in this list. 
     *
     * @return a reference to the last element in this list
     */
    public T last() {
    	
    	if (rear == 0) {
    		throw new EmptyCollectionException("List is Empty.");
    	}
    	
    	return list[rear];
    }

    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target) {    	
    	
    	if (rear == 0)
    		throw new EmptyCollectionException("List is Empty");
    	boolean found = false;
    	for (int i = 0; i < (list.length - 1) && !found; i++) {
    		if (list[i].equals(target)) {
    			found = true;    			    			  			
    		}
    	}    	
    	
    	return found;
    }

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
    	
    	return (rear == 0);
    }

    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    public int size() {
    	
    	return rear;
    }

    /**  
     * Returns an iterator for the elements in this list. 
     *
     * @return an iterator over the elements in this list
     */
    @SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
    	
    	return new ArrayIterator<T>(list, rear);
    }

    /**  
     * Returns a string representation of this list. 
     *
     * @return a string representation of this list
     */
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
    	String result;
    	
    	for (int i = 0; i < rear; i++) {
    		sb.append(list[i] + "\n");
    	}
    	
    	result = sb.toString();
    	return result;
    }
    
    /**
     * Expands the array's capacity by double
     */
    public void expandCapacity() {
    	
    	@SuppressWarnings("unchecked")
		T[] temp  = (T[])new Object[list.length * 2];
        for(int i = 0; i < list.length; i++)
          temp[i] = list[i];
        
        list = temp;
    }
}
