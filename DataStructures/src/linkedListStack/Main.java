package linkedListStack;

public class Main {

    public static void main(String[] args) {
        LinkedStack myStack = new LinkedStack();

        myStack.push(22);
        myStack.push(33);
        myStack.push(45);
        myStack.push(10);
        myStack.push(59);

        //myStack.printStack();
        System.out.println("Top Element: " + myStack.peek());
        System.out.println("Popped Element: " + myStack.pop());

    }
}
