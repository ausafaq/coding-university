package chapter3;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

// Stack of Plates

public class StackOfPlates {

    private List<Stack> stacks;
    private int capacity;

    public StackOfPlates(int capacity) {
        stacks = new ArrayList<>();
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if(stacks.size() == 0) {
            return null;
        } else {
            return stacks.get(stacks.size() - 1);
        }
    }

    public void push(int value) {
        Stack last = getLastStack();
        if(last != null && last.size() != capacity) {
            last.push(value);
        } else {
            Stack newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if(last == null) {
            throw new EmptyStackException();
        } else {
            int poppedValue = (int) last.pop();
            if(last.size() == 0) stacks.remove(stacks.size() - 1);
            return poppedValue;
        }
    }

}
