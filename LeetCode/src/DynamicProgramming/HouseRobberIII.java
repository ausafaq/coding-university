package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    // Brute Force Implementation
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int val = 0;
        if(root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    // DP
    public int robDP(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }

    private int robHelper(TreeNode node, Map<TreeNode, Integer> map) {
        if(node == null) {
            return 0;
        }

        if(map.containsKey(node)) {
            return map.get(node);
        }

        int val = 0;

        if(node.left != null) {
            val += robHelper(node.left.left, map) + robHelper(node.left.right, map);
        }


        if(node.right != null) {
            val += robHelper(node.right.left, map) + robHelper(node.right.right, map);
        }

        val = Math.max(val + node.val, robHelper(node.left, map) + robHelper(node.right, map));
        map.put(node, val);

        return val;
    }
}
