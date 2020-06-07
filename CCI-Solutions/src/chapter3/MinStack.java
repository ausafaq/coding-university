package chapter3;

import java.util.*;

// MinStack using one stack only with constant complexity

public class MinStack {

    class StackNode {
        int value;
        int min;
        StackNode next;

        public StackNode(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    StackNode top;

    public void push(int x) {
        if(top == null) {
            StackNode newNode = new StackNode(x, x);
            top = newNode;
        } else {
            StackNode newNode = new StackNode(x, Math.min(x, top.min));
            newNode.next = top;
            top = newNode;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        if(top != null) {
            return top.value;
        }
        return -1;
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        }
        return -1;
    }
}
