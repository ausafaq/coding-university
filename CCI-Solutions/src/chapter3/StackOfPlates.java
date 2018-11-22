package chapter3;

import java.util.*;

// Stack of Plates

public class StackOfPlates {

    List<Stack> setOfStacks = new ArrayList<Stack>();
    public int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (setOfStacks.size() == 0) {
            return null;
        } else {
            return setOfStacks.get(setOfStacks.size() - 1);
        }
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && last.size() != capacity) {
            last.push(value);
        } else {
            // create new stack
            Stack newStack = new Stack();
            newStack.push(value);
            setOfStacks.add(newStack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        } else {
            int poppedValue = (int) last.pop();
            if (last.size() == 0) {
                setOfStacks.remove(setOfStacks.size() - 1);
            }
            return poppedValue;
        }
    }
}
