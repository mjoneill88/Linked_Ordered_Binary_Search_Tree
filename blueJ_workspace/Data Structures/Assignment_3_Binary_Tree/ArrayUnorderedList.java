/**
 * Unordered list implemented with an array. Implemented for use with an abstract element T.
 *  Elements can be either added to the front, the rear, or 
 *  after a specified element in the list.
 *  
 *  Extends ArrayList<T>
 *  Implements UnorderedListADT<T>
 *  
 * @author Lewis and Chase and Lehmann
 * @version v1
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T>
{
   //-----------------------------------------------------------------
   //  Creates an empty list using the default capacity.
   //-----------------------------------------------------------------
   public ArrayUnorderedList()
   {
      super();
   }

   //-----------------------------------------------------------------
   //  Creates an empty list using the specified capacity.
   //-----------------------------------------------------------------
   public ArrayUnorderedList (int initialCapacity)
   {
      super(initialCapacity);
   }

   //-----------------------------------------------------------------
   //  Adds the specified element to the front of the list.
   //-----------------------------------------------------------------
   public void addToFront (T element)
   {
      if (size() == list.length)
         expandCapacity();
        
      int index = 0;
      // shift the appropriate elements
      for (int scan=index; scan < rear; scan++)
         list[scan+1] = list[scan];

      //insert the element and increment the rear.
      list[0] = element;
      rear++;
 }

   //-----------------------------------------------------------------
   //  Adds the specified element to the rear of the list.
   //-----------------------------------------------------------------
   public void addToRear (T element)
   {
       if (size() == list.length)
            expandCapacity();
            
       list[rear] = element;
       rear++;           
} 

   //-----------------------------------------------------------------
   //  Adds the specified element after the specified target element.
   //  Throws a ElementNotFoundException if the target is not found.
   //-----------------------------------------------------------------
 /**
	 * Adds the specified element after the specified target element. Throws a 
	 * ElementNotFoundException if the target is not found.
	 */
	public void addAfter(T element, T target)
	{
		if (size() == list.length)
		{
			expandCapacity();
		}

		int scan = 0;
           //look for the target element
		while (scan < rear && !target.equals(list[scan]))
		{
			scan++;
		}
		if (scan == rear)
		{
			throw new ElementNotFoundException("in add after method of list");
		}

		scan++;

		//make room for the new item in the list
		for (int scan2 = rear;scan2 > scan;scan2--)
		{
			list[scan2] = list[scan2 - 1];
		}
		list[scan] = element;//place element in the open slot
		rear++;
	}
}



