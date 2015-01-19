import exceptions.EmptyCollectionException;

/**
 * LinkedStack.java
 *
 * COMP 2230 Assignment 1 Question 1
 * Steven Lyall (T00023594)
 *
 * Linked implementation of a stack.
 *
 * @author Java Foundations except where noted
 * @version 4.0
 */

public class LinkedStack<T> implements StackADT<T>
{
    private int count;  
    private LinearNode<T> top;

    /**
     * Creates an empty stack.
     */
    public LinkedStack()
    {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     * @author Java Foundations
     */
    public void push(T element)
    {
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element from top of stack
     * @throws EmptyCollectionException if the stack is empty
     * @author Java Foundations
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        T result = top.getElement();
        top = top.getNext();
        count--;
 
        return result;
    }


    // Additional methods implemented below

    /**
     * Returns the top element in the stack without modifying the stack.
     * @throws EmptyCollectionException if the stack is empty
     * @return top element in stack
     * @author stevelyall
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyCollectionException("Can't peek, stack is empty.");
        }
        return top.getElement();
    }

    /**
     * Checks to see if the stack is empty or not. Since count is equal to the number of elements in the stack, simply checks whether count equals zero.
     * @author stevelyall
     * @return true if count equals zero, false otherwise
     */
    public boolean isEmpty() {
        return (count==0) ? true : false;
    }

    /**
     * Get the number of items in the stack.
     * @author stevelyall
     * @return the value of count
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this stack.
     * @author stevelyall
     * @return string representation of the stack
     */
    public String toString()
    {
        String stackString = "<TOP OF STACK>";
        LinearNode currentNode = top;
        while (currentNode != null) {
            stackString += "\n" + currentNode.getElement();
            currentNode = currentNode.getNext();
        }

        return  stackString + "\n<BOTTOM OF STACK>";
    }


}
