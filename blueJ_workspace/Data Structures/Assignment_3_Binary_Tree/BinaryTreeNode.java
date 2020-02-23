/**
 * Node for a binary tree node that accepts an abstract data type.
 * 
 * @author Lewis and Chase and Lehmann
 * @version v1
 * 
 */
public class BinaryTreeNode<T> {
    
    /* Variables and Objects */
    
    protected T element;
    protected BinaryTreeNode<T> left, right;
    
    
    /**
     * Constructor:
     *  sets element equal to incoming object and sets left and right to null.
     * @param T object
     */
    BinaryTreeNode (T obj) {
        element = obj;
        left = null;
        right = null;
    }
    
    /**
     * Returns the number of children this node has, all the way to the bottom of the tree
     * 
     * @return number of children on particular node
     */
    public int numChildren() {
        
        int children = 0;
        
        if (left != null)
            children += 1 + left.numChildren();
        
        if (right != null)
            children += 1 + right.numChildren();
        
        return children;
    }
    
    /* Debugging only *///==============================================================================
    /*
    public void setLeft(BinaryTreeNode<T> inLeft) {
        left = inLeft;
    }
    
    public void setRight(BinaryTreeNode<T> inRight) {
        right = inRight;
    }
    */
}
