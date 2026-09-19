// LeetCode Problem 496: Next Greater Element I
// Difficulty: Easy
// Link: https://leetcode.com/problems/next-greater-element-i/


public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = {4, 1, 2};
        int[] n2 = {1, 3, 4, 2};
        int[] ans = sol.nextGreaterElement(n1, n2);
        System.out.println("Next greater: " + java.util.Arrays.toString(ans));
    }
}
