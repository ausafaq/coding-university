public class SortedArrayToBinarySearchTree  {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums == null) {
                return null;
            }

            if(nums.length == 1) {
                return new TreeNode(nums[0]);
            }

            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int low, int high) {

            if(low > high) {
                return null;
            }

            int mid = (low + high) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, low, mid - 1);
            root.right = helper(nums, mid + 1, high);
            return root;
        }
    }
}
