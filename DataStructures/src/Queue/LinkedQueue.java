package Queue;

import java.util.NoSuchElementException;

public class LinkedQueue {

    static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node front;
    private Node rear;

    // Add to Queue.
    public void add(int value) {
        Node newNode = new Node(value);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    // Remove from Queue.
    public int remove() {
        if (front == null) {
            throw new NoSuchElementException();
        } else {
            Node temp = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp.value;
        }
    }

    // Peek from Queue.
    public int peek() {
        if (front == null) {
            throw new NoSuchElementException();
        } else {
            return front.value;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void print() {
        Node current = front;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue myQueue = new LinkedQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.print();

        System.out.println("\nFirst Element: " + myQueue.peek());
        System.out.println("\nRemoved Element: " + myQueue.remove());
    }
}
