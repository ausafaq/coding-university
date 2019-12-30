package MinHeap;

import java.util.*;

public class MinHeapPQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding elements to the priority queue
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);

        // Most priority element
        System.out.println("Most priority element: " +pQueue.peek());

        // Printing all elements
        System.out.println("Queue elements: ");
        Iterator itr = pQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Removing the top priority element
        pQueue.poll();
        System.out.println("Queue after poll: ");
        Iterator itr2 = pQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
