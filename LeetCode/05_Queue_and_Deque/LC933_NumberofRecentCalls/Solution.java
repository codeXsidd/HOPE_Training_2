// LeetCode Problem 933: Number of Recent Calls
// Difficulty: Easy
// Link: https://leetcode.com/problems/number-of-recent-calls/

class RecentCounter {
    private java.util.Queue<Integer> q;

    public RecentCounter() {
        q = new java.util.LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}

public class Solution {
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // 1
        System.out.println(counter.ping(100));  // 2
        System.out.println(counter.ping(3001)); // 3
        System.out.println(counter.ping(3002)); // 3
    }
}
