package binaryTree;

public class Main {

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.insert(3);
        myTree.insert(4);
        myTree.insert(5);

        System.out.println(myTree.search(6));
    }
}
