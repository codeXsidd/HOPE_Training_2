// LeetCode Problem 402: Remove K Digits
// Difficulty: Medium
// Link: https://leetcode.com/problems/remove-k-digits/


public class Solution {
    public String removeKdigits(String num, int k) {
        java.util.Deque<Character> stack = new java.util.ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result: " + sol.removeKdigits("1432219", 3)); // "1219"
    }
}
