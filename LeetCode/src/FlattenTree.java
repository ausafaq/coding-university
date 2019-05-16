public class FlattenTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }

     public void flatten(TreeNode root) {

         if(root == null) {
                return;
         }

         if(root.left != null) {
             TreeNode rightChild = root.right;
             root.right = root.left;
             root.left = null;

             TreeNode temp = root;
             while(temp.right != null) {
                 temp = temp.right;
             }

             temp.right = rightChild;
            }

            flatten(root.right);
        }
}
