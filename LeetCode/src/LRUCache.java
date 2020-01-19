import java.util.*;

public class LRUCache {

    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;
    }

    // Hashtable backs up the Doubly Linked List for O(1) access to cache items
    Map<Integer, ListNode> hashtable = new HashMap<Integer, ListNode>();

    ListNode head;
    ListNode tail;
    int totalItemsInCache;
    int maxCapacity;

    public LRUCache(int maxCapacity) {
        // Cache starts empty and capacity is set by client
        int totalItemsInCache = 0;
        this.maxCapacity = maxCapacity;

        // Dummy head and tail nodes to avoid empty state
        head = new ListNode();
        tail = new ListNode();

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = hashtable.get(key);

        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        ListNode node = hashtable.get(key);

        if(node == null) {
            // Item not found, create new entry
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            // Add to the hashtable and update the list
            hashtable.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;

            // If over capacity, remove the item
            if(totalItemsInCache > maxCapacity) {
                removeLRUEntry();
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    private void addToFront(ListNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }

    private void removeLRUEntry() {
        ListNode tail = popTail();
        hashtable.remove(tail.key);
        totalItemsInCache -= 1;
    }

    private ListNode popTail() {
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);
        return tailItem;
    }
}
