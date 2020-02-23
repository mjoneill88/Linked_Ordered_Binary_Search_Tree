
/**
 * Exception class to throw when an element is not found
 * 
 * Extends RuntimeException
 * 
 * @author Brad Stell 
 * @version 11-10-2014
 */
public class ElementNotFoundException extends RuntimeException
{
	/**
	 * This parameterized constructor throws the ElementNotFoundException
	 * @param String msg - exception message
	 */
	public ElementNotFoundException(String msg)
	{
		System.out.print(msg);
	}

 }