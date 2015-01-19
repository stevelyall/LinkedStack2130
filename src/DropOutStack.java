/**
 * DropOutStack.java
 *
 * COMP 2230 Assignment 1 Question 2
 * Steven Lyall (T00023594)
 *
 * Linked implementation of a drop-out stack. When an element is pushed
 * onto a full stack, the last element is lost. Uses a linked structure wth a fixed capacity.
 * 
 **/

import exceptions.EmptyCollectionException;

public class DropOutStack<T> implements StackADT<T> {
	private int capacity;
	private LinearNode<T> top;
	
	/**
	 * Creates a drop-out stack with a given capacity.
	 * @param size the number of elements the stack can hold
	 **/
	DropOutStack(int size) {
		capacity = size;
		top = null;
	}
	
	/**
	 * Pushes an element onto the stack. If the stack is full, the last element is lost.
	 * @param element to be pushed
	 */
	@Override
	public void push(T element) {
		if (size() == capacity) {

			// find the second last element and set its next to null
			LinearNode current = top;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);


		}

		// push the new element
		LinearNode<T> toPush = new LinearNode<T>(element);
		toPush.setNext(top);
		top = toPush;
	}
	
	/**
	 * Pops the top element off the stack and returns it.
	 * @exception EmptyCollectionException if stack is empty
	 * @return element popped from top of stack
	 */
	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't pop, stack is empty.");
		}
		// remove top element and return it
		T element = top.getElement();
		top = top.getNext();
		return element;
	}
	
	/**
	 * Returns the top element in the stack without modifying the stack.
	 * @throws EmptyCollectionException if the stack is empty
	 * @return top element in stack
	 */
	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't peek, stack is empty.");
		}
		return top.getElement();
	}

	/**
	 * Checks to see if the stack is empty or not.
	 * @return true if top is null, false otherwise
	 */
	public boolean isEmpty() {
		return (top==null) ? true : false;
	}

	/**
	 * Get the number of items in the stack.
	 * @return the value of count
	 */
	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}

		LinearNode<T> current = top;
		int numNodes = 0;
		while (current!=null) {
			numNodes++;
			current = current.getNext();

		}

		return numNodes;
	}

	/**
	 * Returns a string representation of this stack.
	 * @return string representation of the stack
	 */
	@Override
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