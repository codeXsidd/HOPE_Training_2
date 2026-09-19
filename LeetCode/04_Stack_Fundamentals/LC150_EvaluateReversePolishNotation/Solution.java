// LeetCode Problem 150: Evaluate Reverse Polish Notation
// Difficulty: Medium
// Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/


public class Solution {
    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("RPN Result: " + sol.evalRPN(tokens));
    }
}
