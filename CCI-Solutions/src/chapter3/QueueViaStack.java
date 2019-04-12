package chapter3;
import java.util.Stack;

// Queues via Stack

public class QueueViaStack {
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStack(){
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size(){

        return stackNewest.size() + stackOldest.size();
    }

    public void add(int value){

        stackNewest.push(value);
    }

    private void shiftOfStack(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public int remove(){
        shiftOfStack();
        return stackOldest.pop();
    }

    public int peek(){
        shiftOfStack();
        return stackOldest.peek();
    }
}

