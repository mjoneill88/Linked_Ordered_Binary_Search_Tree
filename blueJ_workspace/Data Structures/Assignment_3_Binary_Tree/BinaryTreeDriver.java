import java.util.Scanner;
import java.io.*;
import java.util.Iterator;
import java.util.*;
/**
 * This file contains the driver for a Linked Ordered  Binary Search Tree.  This
 * program reads a sentence from a file, placing eah word into a node of a 
 * binary search tree.  Then, the user is given menu options to search the tree,
 * delete from the tree, display an inorder traversal of the tree, or write
 * the inorder traversal to a file.
 * 
 *
 * @author Matthew O'Neill
 * @version 6/23/2019
 */
public class BinaryTreeDriver
{
    
    /**
     * This main method creates a linked ordered binary search tree and
     * gives the user options to search, remove, and display the contents
     * of the tree
     * @param String[] args - command line parameters
     */
    public static void main(String[] args) throws IOException
    {
        //create LinkedBinaryTree instance
        LinkedBinarySearchTree lbst = new LinkedBinarySearchTree();
   
        //create new scanner to get input from file
        Scanner input = new Scanner(new File("inwords.txt"));
        String tempString = "";
        Word tempWord;
    
        //grab each word from file
        while(input.hasNext()){
            tempString = input.next();
            tempString = tempString.toLowerCase();
            //place string inside word object
            tempWord = new Word(tempString);
            //if binary tree is empty just add element to it
            if(lbst.size() == 0){
                lbst.addElement(tempWord);
            }
            //if word is already in binary tree, increment word's count
            else if(lbst.contains(tempWord)){
                Word incrementCountWord = (Word)lbst.find(tempWord);
                incrementCountWord.increaseCount();
            }
            //if word is not in binary tree add it to tree
            else{
                lbst.addElement(tempWord);
            }
    }
    
    //create scanner to get user's menu choices
    input = new Scanner(System.in);
    int choice = 1;
    
    //keep program running until user decides to quit
    while(choice != 7){
        //choice menu
        System.out.println("------------------------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1: Search for a Word");
        System.out.println("2: Delete a Word");
        System.out.println("3: Display the inorder traversal of the tree");
        System.out.println("4: Output the inorder traversal to a file named outwords.txt");
        System.out.println("7: Quit");
        System.out.println("------------------------------------------------------------");
        choice = input.nextInt();
         
        //execute menu
        switch(choice){
            //option 1: search for a word in the binary tree
            case 1:
                //get search word from user and place in word object
                Scanner input2 = new Scanner(System.in);
                System.out.println("What is the word?");
                String userWord = input2.next();
                Word userWordWord = new Word(userWord);
                //if word is in list, display it
                if(lbst.contains(userWordWord)){
                    Word addWord = (Word)lbst.find(userWordWord);
                    System.out.println("Found: " + addWord.toString());
                }
                //if word is not in list, notify user
                else{
                    System.out.println("Word not in Tree");
                    //throw new ElementNotFoundException("Word not in tree");
                }
                break;
            //option 2: delete a word
            case 2:
                //get string from user and place within Word object
                Scanner input3 = new Scanner(System.in);
                System.out.println("What word do you want to delete?");
                String userWord2 = input3.next();
                
                Word userWordWord2 = new Word(userWord2);
                //find the word within the binary tree using the find() method
                Word decrementWord = (Word)lbst.find(userWordWord2);
                //if word is in tree...
                if(lbst.contains(userWordWord2)){
                    //if there is only one ocurrence of the word, remove the node
                    if(decrementWord.getCount() == 1){
                        //actually remove binary node
                        Word removedWord = (Word)lbst.removeElement(userWordWord2);
                        System.out.println("You just removed: " + removedWord.toString());
                    }
                    //if there is more than mone occurence, decrease word count
                    else{
                        decrementWord.decreaseCount();
                        System.out.println("You just removed: " + decrementWord.toString());
                    }
                    
                }
                //else if element not found in tree
                else{
                    System.out.println("Element not contained in Tree");
                }
                break;
            //option 3: display in-order traversal of binary tree
            case 3:
                //create new Iterator object to traverse tree
                //call .iteratorInOrder() to create iterator
                //capable of traversing in inorder
                Iterator<Word> it = lbst.iteratorInOrder();
                //display each binary tree node
                int displayCount = 1;
                while(it.hasNext()){
                    System.out.print(it.next().toString() + "   ");
                    if(displayCount % 7 == 0){
                        System.out.println("\n");
                    }
                    displayCount++;
                }
                System.out.println("");
                break;
            //option 4: write inorder traversal to file
            case 4:
                //create new Iterator object to traverse tree
                Iterator<Word> itOut = lbst.iteratorInOrder();
                //create new PrintWriter object to write to file
                PrintWriter output = new PrintWriter("outwords.txt");
                //append tree nodes to empty string
                String outputString = "";
                while(itOut.hasNext()){
                    outputString += itOut.next();
                }
                //write to file and close PrintWriter
                output.println(outputString);
                output.close();
                break;
            //option 7: quit program
            case 7:
                System.out.println("The program has ended");
                break;
            //default option: incorrect integer input
            default:
                System.out.println("Incorrect input, try again.");
                break;
        }
    }
    
    }
    
}
