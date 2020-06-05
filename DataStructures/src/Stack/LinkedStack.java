package Stack;

import java.util.EmptyStackException;

public class LinkedStack {

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node temp = top;
            top = top.next;
            return temp.value;
        }
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    public void printStack() {
        while(top != null) {
            System.out.println(top.value + " ");
            top = top.next;
        }
    }

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
