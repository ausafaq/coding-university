package linkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtHead(1);
        list.addAtIndex(1, 5);
        list.addAtTail(6);

        list.traverseList();

        list.deleteAtIndex(1);

        list.traverseList();
    }
}
