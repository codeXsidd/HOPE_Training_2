// LeetCode Problem 1670: Design Front Middle Back Queue
// Difficulty: Medium
// Link: https://leetcode.com/problems/design-front-middle-back-queue/

class FrontMiddleBackQueue {
    private java.util.Deque<Integer> left = new java.util.ArrayDeque<>();
    private java.util.Deque<Integer> right = new java.util.ArrayDeque<>();

    public FrontMiddleBackQueue() {}

    private void balance() {
        while (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        while (right.size() > left.size() + 1) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() == right.size()) {
            right.addFirst(val);
        } else {
            left.addLast(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (isEmpty()) return -1;
        int val = left.isEmpty() ? right.removeFirst() : left.removeFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (isEmpty()) return -1;
        int val = (left.size() == right.size()) ? left.removeLast() : right.removeFirst();
        balance();
        return val;
    }

    public int popBack() {
        if (isEmpty()) return -1;
        int val = right.removeLast();
        balance();
        return val;
    }

    private boolean isEmpty() {
        return left.isEmpty() && right.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        System.out.println("Pop front: " + q.popFront());   // 1
        System.out.println("Pop middle: " + q.popMiddle()); // 3
        System.out.println("Pop middle: " + q.popMiddle()); // 4
        System.out.println("Pop back: " + q.popBack());     // 2
    }
}
