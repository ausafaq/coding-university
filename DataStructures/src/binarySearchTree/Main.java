package binarySearchTree;

public class Main {

    public static void main(String[] args){

        Tree intTree  = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        /*System.out.print("\n InOrder Traversal -> ");
        intTree.traverseInOrder();

        System.out.print("\n PreOrder Traversal -> ");
        intTree.traversePreOrder();

        System.out.print("\n PostOrder Traversal -> ");
        intTree.traverserPostOrder();*/

        System.out.println(intTree.max());
    }
}
