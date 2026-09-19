// LeetCode Problem 222: Count Complete Tree Nodes
// Difficulty: Easy
// Link: https://leetcode.com/problems/count-complete-tree-nodes/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftH = getLeftHeight(root);
        int rightH = getRightHeight(root);
        if (leftH == rightH) {
            return (1 << leftH) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftHeight(TreeNode node) {
        int h = 0;
        while (node != null) { h++; node = node.left; }
        return h;
    }

    private int getRightHeight(TreeNode node) {
        int h = 0;
        while (node != null) { h++; node = node.right; }
        return h;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        Solution sol = new Solution();
        System.out.println("Total complete tree nodes: " + sol.countNodes(root));
    }
}
