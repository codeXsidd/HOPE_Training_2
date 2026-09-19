// LeetCode Problem 901: Online Stock Span
// Difficulty: Medium
// Link: https://leetcode.com/problems/online-stock-span/

class StockSpanner {
    private java.util.Stack<int[]> stack; // [price, span]

    public StockSpanner() {
        stack = new java.util.Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}

public class Solution {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100)); // 1
        System.out.println(spanner.next(80));  // 1
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(70));  // 2
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(75));  // 4
        System.out.println(spanner.next(85));  // 6
    }
}
