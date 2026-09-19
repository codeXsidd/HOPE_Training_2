// LeetCode Problem 94: Binary Tree Inorder Traversal
// Difficulty: Easy
// Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    public java.util.List<Integer> inorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, java.util.List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution sol = new Solution();
        System.out.println("Inorder: " + sol.inorderTraversal(root));
    }
}
