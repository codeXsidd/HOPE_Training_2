// LeetCode Problem 144: Binary Tree Preorder Traversal
// Difficulty: Easy
// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    public java.util.List<Integer> preorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, java.util.List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution sol = new Solution();
        System.out.println("Preorder: " + sol.preorderTraversal(root));
    }
}
