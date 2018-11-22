package linkedListStack;

import java.util.EmptyStackException;

public class LinkedStack {
    private StackNode top;

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int value){
        StackNode intValue = new StackNode(value);
        intValue.setNext(top);
        top = intValue;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            StackNode temp = top;
            top = top.getNext();
            return temp.getValue();
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else return top.getValue();
    }

    public void printStack(){
        while(top != null){
            System.out.print(top.getValue() + ", ");
            top = top.getNext();
        }
    }
}
