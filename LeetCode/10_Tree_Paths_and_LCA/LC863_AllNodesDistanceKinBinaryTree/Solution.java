// LeetCode Problem 863: All Nodes Distance K in Binary Tree
// Difficulty: Medium
// Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

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
    public java.util.List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        java.util.Map<TreeNode, TreeNode> parentMap = new java.util.HashMap<>();
        buildParentMap(root, null, parentMap);

        java.util.List<Integer> result = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        java.util.Set<TreeNode> visited = new java.util.HashSet<>();

        queue.offer(target);
        visited.add(target);
        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) {
                while (!queue.isEmpty()) result.add(queue.poll().val);
                return result;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && visited.add(curr.left)) queue.offer(curr.left);
                if (curr.right != null && visited.add(curr.right)) queue.offer(curr.right);
                TreeNode parent = parentMap.get(curr);
                if (parent != null && visited.add(parent)) queue.offer(parent);
            }
            currentDistance++;
        }
        return result;
    }

    private void buildParentMap(TreeNode node, TreeNode parent, java.util.Map<TreeNode, TreeNode> map) {
        if (node == null) return;
        if (parent != null) map.put(node, parent);
        buildParentMap(node.left, node, map);
        buildParentMap(node.right, node, map);
    }

    public static void main(String[] args) {
        TreeNode target = new TreeNode(5);
        TreeNode root = new TreeNode(3, target, new TreeNode(1));
        Solution sol = new Solution();
        System.out.println("Distance 1 from node 5: " + sol.distanceK(root, target, 1));
    }
}
