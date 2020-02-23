import java.util.*;

/**
 * ArrayIterator.java      
 *
 *  Represents an iterator over the elements of an array.
 *  To use this iterator in your code for the ArrayList
 *  you must send in a reference to the array and the count
 *  of the number of elements in the list.
 * 
 *  @author Lewis and Chase and Lehmann
 *  @version v1
 *  
 */
public class ArrayIterator<T> implements Iterator<T>
{
   private int count;    // the number of elements in the list
   private int current;  // the subscript of current item in the iteration 
   private T[] items; //the array sent in to the constructor- the list

   //-----------------------------------------------------------------
   //  Sets up this iterator using the specified items.
   //-----------------------------------------------------------------
   public ArrayIterator (T[] collection, int size)
   {
      items = collection;
      count = size;
      current = 0;
   }

   //-----------------------------------------------------------------
   //  Returns true if this iterator has at least one more element
   //  to deliver in the iteraion.
   //-----------------------------------------------------------------
   public boolean hasNext()
   {
      return (current < count);
   }

   //-----------------------------------------------------------------
   //  Returns the next element in the iteration. If there are no
   //  more elements in this itertion, a NoSuchElementException is
   //  thrown.
   //-----------------------------------------------------------------
   public T next()
   {
      if (! hasNext())

         throw new NoSuchElementException();

 	 current++;
      return items[current - 1]; 
	 
   }

   //-----------------------------------------------------------------
   //  The remove operation is not supported in this collection.
   //-----------------------------------------------------------------
   public void remove() throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}

