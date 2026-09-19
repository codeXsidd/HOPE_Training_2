// LeetCode Problem 113: Path Sum II
// Difficulty: Medium
// Link: https://leetcode.com/problems/path-sum-ii/

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
    public java.util.List<java.util.List<Integer>> pathSum(TreeNode root, int targetSum) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.List<Integer> currentPath = new java.util.ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int sum, java.util.List<Integer> currentPath, java.util.List<java.util.List<Integer>> result) {
        if (node == null) return;
        currentPath.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new java.util.ArrayList<>(currentPath));
        } else {
            dfs(node.left, sum - node.val, currentPath, result);
            dfs(node.right, sum - node.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8));
        Solution sol = new Solution();
        System.out.println("Path sum 22 paths: " + sol.pathSum(root, 22));
    }
}
