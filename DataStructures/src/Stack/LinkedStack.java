package Stack;

import java.util.EmptyStackException;

public class LinkedStack<T> {

    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            Node<T> temp = top;
            top = top.next;
            return temp.value;
        }
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    public void printStack() {
        Node<T> temp = top;
        while(temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> myStack = new LinkedStack<>();

        myStack.push(22);
        myStack.push(33);
        myStack.push(45);
        myStack.push(10);
        myStack.push(59);

        myStack.printStack();
        System.out.println("Top Element: " + myStack.peek());
        System.out.println("Popped Element: " + myStack.pop());
    }
}
