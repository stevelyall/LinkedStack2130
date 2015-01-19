import exceptions.EmptyCollectionException;

/**
 * LinkedStackDriver.java
 *
 * COMP 2230 Assignment 1
 * Steven Lyall (T00023594)
 *
 * Tests LinkedStack and DropOutStack.
 *
 * @author stevelyall
 *
 */
public class LinkedStackDriver {
    public static void main (String[] args) {

        // ===================
        // testing LinkedStack
        // ===================
        System.out.println("\n** Test output for LinkedStack **\n");

        // instantiate new LinkedStack
        LinkedStack<String> stack = new LinkedStack<String>();

        // test peeking and popping empty stack, should throw exception
        System.out.println("Popping empty stack, which throws EmptyCollectionException:");
        try {
            System.out.println(stack.pop());
        }
        catch (EmptyCollectionException e) {
            System.out.println(e.getClass() + " " +  e.getMessage() + "\n");
        }
        System.out.println("Peeking at empty stack, which throws EmptyCollectionException:");
        try {
            System.out.println(stack.peek());
        }
        catch (EmptyCollectionException e) {
            System.out.println(e.getClass() + " " +  e.getMessage() + "\n");

        }

        // push an element onto stack, stack should have one element
        System.out.println("Pushing an element...");
        stack.push("One");
        System.out.println("After pushing a single element, the stack should have one element \"One\"");
        System.out.println(stack);
        System.out.println();

        // pop the element, stack should be empty again
        System.out.println("Popping...");
        stack.pop();
        System.out.println("After the pop operation, stack should be empty:");
        System.out.println(stack);

        // push more elements
        System.out.println("Pushing an element...");
        stack.push("Two");
        System.out.println("Pushing an element...");
        stack.push("Three");
        System.out.println("Pushing an element...");
        stack.push("Four");
        System.out.println("Pushing an element...");
        stack.push("Five");
        System.out.println("Pushing an element...");
        stack.push("Six");
        System.out.println("Pushing an element...");
        stack.push("Seven");
        System.out.println("Stack with six elements:");
        System.out.println(stack);
        System.out.println();

        // test peeking at top element from stack
        System.out.println("Peeking at top element..");
        System.out.println(stack.peek());
        System.out.println();

        // test popping top element from stack
        System.out.println("Popping...");
        System.out.println(stack.pop());
        System.out.println("Stack after pop operation:");
        System.out.println(stack);
        System.out.println();


        // ====================
        // testing DropOutStack
        // ====================
        System.out.println("\n** Test output for DropOutStack **\n");
        // instantiate new DropOutStack with capacity of 5
        DropOutStack<String> dropStack = new DropOutStack<String>(5);

        // test peeking and popping empty stack, should throw exception
        System.out.println("Popping empty stack, which throws EmptyCollectionException:");
        try {
            System.out.println(dropStack.pop());
        }
        catch (EmptyCollectionException e) {
            System.out.println(e.getClass() + " " +  e.getMessage() + "\n");
        }
        System.out.println("Peeking at empty stack, which throws EmptyCollectionException:");
        try {
            System.out.println(dropStack.peek());
        }
        catch (EmptyCollectionException e) {
            System.out.println(e.getClass() + " " +  e.getMessage() + "\n");

        }

        // push 3 elements to stack of size 5, stack not full
        System.out.println("Pushing an element...");
        dropStack.push("One");
        System.out.println("Pushing an element...");
        dropStack.push("Two");
        System.out.println("Pushing an element...");
        dropStack.push("Three");
        System.out.println("After 3 push operations, the stack looks like this:");
        System.out.println(dropStack);
        System.out.println();

        // push 3 more elements to stack, should drop first element pushed to stack ("One")
        System.out.println("Pushing an element...");
        dropStack.push("Four");
        System.out.println("Pushing an element...");
        dropStack.push("Five");
        System.out.println("Pushing an element...");
        dropStack.push("Six");
        System.out.println("Stack after 3 more push operations, first element \"One\" is lost:");
        System.out.println(dropStack);
        System.out.println();

        // test peeking at top element from stack
        System.out.println("Peeking at top element..");
        System.out.println(dropStack.peek());
        System.out.println();

        // test popping top element from stack
        System.out.println("Popping next element");
        dropStack.pop();
        System.out.println("Stack after pop operation:");
        System.out.println(dropStack);
        System.out.println();

        // push another element
        System.out.println("Pushing another element...");
        dropStack.push("Seven");
        System.out.println("After push operation:");
        System.out.println(dropStack);
        System.out.println();

        // pop all elements from stack, stack should be empty
        System.out.println("Popping all elements from stack:");
        dropStack.pop();
        dropStack.pop();
        dropStack.pop();
        dropStack.pop();

        System.out.println("Stack is empty:");
        System.out.println(dropStack);


    }
}
