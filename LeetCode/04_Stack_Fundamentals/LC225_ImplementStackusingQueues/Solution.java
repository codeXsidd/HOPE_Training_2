// LeetCode Problem 225: Implement Stack using Queues
// Difficulty: Easy
// Link: https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    private java.util.Queue<Integer> queue = new java.util.LinkedList<>();

    public MyStack() {}

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top()); // 2
        System.out.println("Pop: " + stack.pop()); // 2
        System.out.println("Empty: " + stack.empty()); // false
    }
}
