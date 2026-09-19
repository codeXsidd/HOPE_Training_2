// LeetCode Problem 622: Design Circular Queue
// Difficulty: Medium
// Link: https://leetcode.com/problems/design-circular-queue/

class MyCircularQueue {
    private int[] data;
    private int head = 0;
    private int tail = -1;
    private int size = 0;
    private int capacity;

    public MyCircularQueue(int k) {
        data = new int[k];
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1)); // true
        System.out.println(queue.enQueue(2)); // true
        System.out.println(queue.enQueue(3)); // true
        System.out.println(queue.enQueue(4)); // false
        System.out.println(queue.Rear());     // 3
        System.out.println(queue.isFull());   // true
        System.out.println(queue.deQueue());  // true
        System.out.println(queue.enQueue(4)); // true
        System.out.println(queue.Rear());     // 4
    }
}
