package Queue;

public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue(int capacity) {
        this.queue = new int[capacity];
        this.capacity = capacity;
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if(isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (rear == size - 1) {
            rear = -1;
        }

        /* increment rear then insert element to queue */
        queue[++rear] = item;
        size++;
    }

    public int delete() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        /* retrieve queue element then increment */
        int temp = queue[front++];
        if (front == capacity) {
            front = 0;
        }

        size--;
        return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args)
    {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Item deleted from queue: " + queue.delete());
        System.out.println("Item deleted from queue: " + queue.delete());
        queue.enqueue(5);
        System.out.println("Item deleted from queue: " + queue.delete());
    }
}