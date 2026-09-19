// LeetCode Problem 124: Binary Tree Maximum Path Sum
// Difficulty: Hard
// Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxGain(root, maxSum);
        return maxSum[0];
    }

    private int maxGain(TreeNode node, int[] maxSum) {
        if (node == null) return 0;
        int leftGain = Math.max(0, maxGain(node.left, maxSum));
        int rightGain = Math.max(0, maxGain(node.right, maxSum));
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum[0] = Math.max(maxSum[0], priceNewPath);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution sol = new Solution();
        System.out.println("Max path sum: " + sol.maxPathSum(root)); // 42
    }
}
