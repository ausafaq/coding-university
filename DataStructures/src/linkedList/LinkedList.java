package linkedList;

public class LinkedList {

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

        Node temp = head.getNext();
        int idx = 1;
        while (idx < index) {
            temp = temp.getNext();
            idx++;
        }
        return temp;
    }


    public int get(int index) {
        Node result = findAtIndex(index);
        return result != null ? result.getValue() : -1;
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
            newNode.setNext(head);
            head = newNode;
        } else {
            newNode.setNext(nodeAtIndex.getNext());
            nodeAtIndex.setNext(newNode);
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
            head = head.getNext();
        } else {
            Node nodeAtIndex = findAtIndex(index - 1);
            nodeAtIndex.setNext(nodeAtIndex.getNext().getNext());
        }
        length--;
    }

    public void traverseList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
