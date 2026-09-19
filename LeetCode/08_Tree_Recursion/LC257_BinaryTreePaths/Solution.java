// LeetCode Problem 257: Binary Tree Paths
// Difficulty: Easy
// Link: https://leetcode.com/problems/binary-tree-paths/

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
    public java.util.List<String> binaryTreePaths(TreeNode root) {
        java.util.List<String> paths = new java.util.ArrayList<>();
        if (root != null) dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, java.util.List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }
        if (node.left != null) dfs(node.left, path + node.val + "->", paths);
        if (node.right != null) dfs(node.right, path + node.val + "->", paths);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        Solution sol = new Solution();
        System.out.println("Root-to-leaf paths: " + sol.binaryTreePaths(root));
    }
}
