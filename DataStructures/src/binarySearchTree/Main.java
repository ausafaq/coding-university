package binarySearchTree;

public class Main {

    public static void main(String[] args){
        BinaryTree myTree = new BinaryTree();
        myTree.insert(4);
        myTree.insert(2);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(3);

        myTree.inorderTraversal();

    }
}
