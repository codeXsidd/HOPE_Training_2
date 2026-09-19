// LeetCode Problem 437: Path Sum III
// Difficulty: Medium
// Link: https://leetcode.com/problems/path-sum-iii/

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
    public int pathSum(TreeNode root, int targetSum) {
        java.util.Map<Long, Integer> prefixSumMap = new java.util.HashMap<>();
        prefixSumMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, java.util.Map<Long, Integer> prefixSumMap) {
        if (node == null) return 0;
        currentSum += node.val;
        int count = prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        count += dfs(node.left, currentSum, targetSum, prefixSumMap);
        count += dfs(node.right, currentSum, targetSum, prefixSumMap);
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(2)), new TreeNode(-3, null, new TreeNode(11)));
        Solution sol = new Solution();
        System.out.println("Path sum count (target=8): " + sol.pathSum(root, 8));
    }
}
