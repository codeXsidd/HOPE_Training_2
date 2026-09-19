// LeetCode Problem 20: Valid Parentheses
// Difficulty: Easy
// Link: https://leetcode.com/problems/valid-parentheses/


public class Solution {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("()[]{} is valid: " + sol.isValid("()[]{}"));
        System.out.println("(] is valid: " + sol.isValid("(]"));
    }
}
