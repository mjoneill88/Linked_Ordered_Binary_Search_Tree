
/**
 * This Word class contains the code for a Word object of generic type.
 *
 * Implements: Comparable<T>
 *
 * @author Matthew O'Neill
 * @version 6/23/2019
 */
public class Word<T> implements Comparable<T>
{
    private String text;
    private int count;
    
    /**
     * This parameterized constructor sets the value of the text field to the
     * String passed into the constructor.  It also sets the word's count cield
     * to 1.
     * @param String inText - text field
     */
    public Word(String inText)
    {
        this.text = inText;
        count = 1;
    }
    
    /**
     * This getText method returns the text field.
     * @return String text - text field
     */
    public String getText()
    {
        return this.text;
    }
    
    /**
     * This compareTo method compares the text field of two Word objects
     * and returns and int
     * @param T other - generic object to be compared 
     * @return int - result of comparison
     */
    public int  compareTo(T other)
    {
        Word compWord = (Word)other;
        return this.text.compareTo(compWord.text);
    }
    
    /**
     * This equals method compares the text field of two Word objects
     * and returns a boolean
     * @param Word other - object being passed in
     * @return boolean - result of comparison
     */
    public boolean equals(Word other)
    {
        Word compWord = (Word)other;
        return this.text.equals(compWord.text);
    }
    
    /**
     * This toString method returns a String representation of
     * the Word object in the form word(count).
     * @return - String representation of Word object
     */
    public String toString()
    {
        return this.text + "("+ count + ")";
    }
    
    /**
     * This increaseCount method increases the count of the word
     * object
     */
    public void increaseCount(){
        this.count = count + 1;
    }
    
    /**
     * This decreaseCount method decreases the count of the word
     * object
     */
    public void decreaseCount()
    {
        this.count = count - 1;
    }
    
    /**
     * This getCount method returns the count field of a word
     * object
     * @return int count - count field
     */
    public int getCount()
    {
        return this.count;
    }
}
