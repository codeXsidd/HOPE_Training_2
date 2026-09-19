// LeetCode Problem 145: Binary Tree Postorder Traversal
// Difficulty: Easy
// Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    public java.util.List<Integer> postorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, java.util.List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution sol = new Solution();
        System.out.println("Postorder: " + sol.postorderTraversal(root));
    }
}
