package Queue;

import java.util.NoSuchElementException;

public class LinkedQueue {
    private QueueNode first;
    private QueueNode last;

    // Add to queue
    public void add(int value) {
        QueueNode newNode = new QueueNode(value);
        if (last != null) {
            last.setNext(newNode);
        }
        last = newNode;
        if (first == null) {
            first = last;
        }
    }

    // Remove from queue
    public int remove() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            QueueNode temp = first;
            first = first.getNext();
            if (first == null) {
                last = null;
            }
            return temp.getValue();
        }
    }

    // Peek from queue
    public int peek() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return first.getValue();
        }
    }

    public boolean isEmpty() {

        return first == null;
    }

    public void printQueue() {
        QueueNode current = first;
        while (current != null) {
            System.out.print(current.getValue() + ", ");
            current = current.getNext();
        }
    }
}
