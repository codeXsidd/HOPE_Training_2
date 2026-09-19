// LeetCode Problem 226: Invert Binary Tree
// Difficulty: Easy
// Link: https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        Solution sol = new Solution();
        TreeNode inverted = sol.invertTree(root);
        System.out.println("Root after inversion: " + inverted.val);
        System.out.println("Left child: " + inverted.left.val + ", Right child: " + inverted.right.val);
    }
}
