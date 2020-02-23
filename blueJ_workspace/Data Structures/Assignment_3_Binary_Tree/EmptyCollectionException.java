/**
 * Represents the situation in which a collection is empty.
 *
 * Extends RuntimeException
 * 
 * @author Lewis and Chase
 * @version v1
 */
public class EmptyCollectionException extends RuntimeException
{
    /**
     * Accepts a message to be displayed
     * @param String, message to be displayed
     */
    public EmptyCollectionException(String msg)
    {
        System.out.print(msg);
    }
}
