// LeetCode Problem 641: Design Circular Deque
// Difficulty: Medium
// Link: https://leetcode.com/problems/design-circular-deque/

class MyCircularDeque {
    private int[] data;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        data = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : data[(rear - 1 + capacity) % capacity];
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
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));  // true
        System.out.println(deque.insertLast(2));  // true
        System.out.println(deque.insertFront(3)); // true
        System.out.println(deque.insertFront(4)); // false (full)
        System.out.println(deque.getRear());      // 2
        System.out.println(deque.isFull());       // true
        System.out.println(deque.deleteLast());   // true
        System.out.println(deque.insertFront(4)); // true
        System.out.println(deque.getFront());     // 4
    }
}
