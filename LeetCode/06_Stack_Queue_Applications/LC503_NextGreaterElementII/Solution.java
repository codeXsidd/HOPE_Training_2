// LeetCode Problem 503: Next Greater Element II
// Difficulty: Medium
// Link: https://leetcode.com/problems/next-greater-element-ii/


public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        java.util.Arrays.fill(result, -1);
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println("Next greater circular: " + java.util.Arrays.toString(res));
    }
}
