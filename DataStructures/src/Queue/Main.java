package Queue;

public class Main {

    public static void main(String[] args) {

        LinkedQueue myQueue = new LinkedQueue();

        myQueue.add(20);
        myQueue.add(56);
        myQueue.add(78);
        myQueue.add(12);

        myQueue.printQueue();
        System.out.println();
        System.out.println("First Element: " + myQueue.peek());
        System.out.println();
        System.out.println("Removed Element: " + myQueue.remove());

    }
}
