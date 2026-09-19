// LeetCode Problem 155: Min Stack
// Difficulty: Medium
// Link: https://leetcode.com/problems/min-stack/

class MinStack {
    private java.util.Stack<Integer> stack;
    private java.util.Stack<Integer> minStack;

    public MinStack() {
        stack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // 0
        System.out.println("Min: " + minStack.getMin()); // -2
    }
}
