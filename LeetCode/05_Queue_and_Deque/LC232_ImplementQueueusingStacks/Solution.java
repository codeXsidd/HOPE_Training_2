// LeetCode Problem 232: Implement Queue using Stacks
// Difficulty: Easy
// Link: https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    private java.util.Stack<Integer> in = new java.util.Stack<>();
    private java.util.Stack<Integer> out = new java.util.Stack<>();

    public MyQueue() {}

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        peek();
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek()); // 1
        System.out.println("Pop: " + queue.pop());   // 1
        System.out.println("Empty: " + queue.empty()); // false
    }
}
