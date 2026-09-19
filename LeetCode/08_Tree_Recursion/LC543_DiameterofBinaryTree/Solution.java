// LeetCode Problem 543: Diameter of Binary Tree
// Difficulty: Easy
// Link: https://leetcode.com/problems/diameter-of-binary-tree/

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        maxDepth(root, maxDiameter);
        return maxDiameter[0];
    }

    private int maxDepth(TreeNode node, int[] maxDiameter) {
        if (node == null) return 0;
        int left = maxDepth(node.left, maxDiameter);
        int right = maxDepth(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        Solution sol = new Solution();
        System.out.println("Diameter: " + sol.diameterOfBinaryTree(root));
    }
}
