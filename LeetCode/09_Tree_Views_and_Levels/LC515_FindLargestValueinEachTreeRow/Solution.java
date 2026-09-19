// LeetCode Problem 515: Find Largest Value in Each Tree Row
// Difficulty: Medium
// Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    public java.util.List<Integer> largestValues(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) return result;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                maxVal = Math.max(maxVal, curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(maxVal);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        Solution sol = new Solution();
        System.out.println("Largest in each row: " + sol.largestValues(root));
    }
}
