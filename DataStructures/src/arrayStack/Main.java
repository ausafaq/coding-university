package arrayStack;

public class Main {

    public static void main(String[] args) {
        ArrayStack myStack = new ArrayStack(10);

        myStack.push(10);
        myStack.push(20);
        myStack.push(5);
        myStack.push(17);
        myStack.push(80);

        myStack.printStack();

        System.out.println("\nTop Element: " + myStack.peek());
        System.out.println("\nPopped element: " + myStack.pop());

    }
}
