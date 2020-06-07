package chapter3;

// Single array to implement 3 stacks

// Fixed Division

public class ThreeInOne {

    private int numberOfStacks = 3;
    private int capacity;
    private int[] values;
    private int[] sizes;


    public ThreeInOne(int capacity) {
        this.capacity = capacity;
        values = new int[capacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    // push value into stack
    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)) {
            throw new Exception("Particular Stack is already full");
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    // Check if stack is empty
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    // Check if stack is full
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == capacity;
    }

    // index of the top of the stack
    public int indexOfTop(int stackNum) {
        int offset = stackNum * capacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}


