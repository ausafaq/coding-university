package binarySearchTree;

public class Main {

    public static void main(String[] args){
        Tree myTree = new Tree();
        myTree.insert(4);
        myTree.insert(2);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(3);
        //myTree.traversePostOrder();

        System.out.println(myTree.hasPathSum(9));
    }
}
