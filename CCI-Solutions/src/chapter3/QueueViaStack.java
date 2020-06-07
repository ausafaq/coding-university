package chapter3;
import java.util.Stack;

// Queues via Stack
public class QueueViaStack<T> {
    Stack<T> oldStack, newStack;

    public QueueViaStack() {
        oldStack = new Stack<T>();
        newStack = new Stack<T>();
    }

    public int size() {
        return newStack.size() + oldStack.size();
    }

    public void add(T value) {
        newStack.push(value);
    }

    private void shiftOfStack() {
        if (oldStack.isEmpty()) {
            while (!newStack.isEmpty()) {
                oldStack.push(newStack.pop());
            }
        }
    }

    public T remove() {
        shiftOfStack();
        return oldStack.pop();
    }

    public T peek() {
        shiftOfStack();
        return oldStack.peek();
    }
}

