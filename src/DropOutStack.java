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

public class DropOutStack<T> extends LinkedStack<T> {
	private int capacity;

	
	/**
	 * Creates a drop-out stack with a given capacity.
	 * @param capacity the number of elements the stack can hold
	 **/
	DropOutStack(int capacity) {
		super();
		this.capacity = capacity;
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

}