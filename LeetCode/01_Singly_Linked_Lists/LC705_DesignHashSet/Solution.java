// LeetCode Problem 705: Design HashSet
// Difficulty: Easy
// Link: https://leetcode.com/problems/design-hashset/

class MyHashSet {
    private final int BUCKETS = 1000;
    private java.util.LinkedList<Integer>[] table;

    public MyHashSet() {
        table = new java.util.LinkedList[BUCKETS];
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void add(int key) {
        int idx = hash(key);
        if (table[idx] == null) {
            table[idx] = new java.util.LinkedList<>();
        }
        if (!table[idx].contains(key)) {
            table[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        if (table[idx] != null) {
            table[idx].remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return table[idx] != null && table[idx].contains(key);
    }
}

public class Solution {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println("Contains 1: " + set.contains(1)); // true
        System.out.println("Contains 3: " + set.contains(3)); // false
        set.add(2);
        System.out.println("Contains 2: " + set.contains(2)); // true
        set.remove(2);
        System.out.println("Contains 2 after remove: " + set.contains(2)); // false
    }
}
