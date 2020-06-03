public class LinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int length = 0;

    // Check whether list is empty
    public boolean isEmpty() {

        return length == 0;
    }

    // Size of the linked list
    public int size() {

        return length;
    }

    // Find at index
    private Node findAtIndex(int index) {

        if (length == 0 || index > length - 1) {
            return null;
        }

        if (index <= 0) {
            return head;
        }

        Node temp = head.next;
        int idx = 1;
        while (idx < index) {
            temp = temp.next;
            idx++;
        }
        return temp;
    }


    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.val : -1;
    }

    // Insert an element at the beginning of the linked list
    public void addAtHead(int value) {

        addAtIndex(0, value);
    }

    // Insert an element at a particular index of the linked list
    public void addAtIndex(int index, int value) {
        if (index > length) {
            return;
        }

        Node newNode = new Node(value);
        Node nodeAtIndex = findAtIndex(index - 1);

        if (isEmpty()) {
            head = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = nodeAtIndex.next;
            nodeAtIndex.next = newNode;
        }
        length++;
    }

    // Insert an element at the end of the linked list
    public void addAtTail(int value) {
        addAtIndex(length, value);
    }

    // Remove an element at a particular index
    public void deleteAtIndex(int index) {

        if(length == 0 || index > length - 1 || index < 0) {
            return;
        }

        if(index == 0) {
            head = head.next;
        } else {
            Node nodeAtIndex = findAtIndex(index - 1);
            nodeAtIndex.next = nodeAtIndex.next.next;
        }
        length--;
    }

    // Traverse linked list
    public void traverseList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Middle of a linked list
    public int middleNode() {
        Node fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtHead(1);
        list.addAtTail(2);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(5);
        list.addAtTail(6);
        list.addAtTail(7);
        list.traverseList();
        System.out.println("Middle Node: " +list.middleNode());
        System.out.println("Element at index 2: " +list.get(2));
        System.out.println(list.isEmpty());

    }

}
