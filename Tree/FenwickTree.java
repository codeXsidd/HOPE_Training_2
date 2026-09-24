package Tree;

import java.util.Arrays;

/**
 * Fenwick Tree (Binary Indexed Tree / BIT)
 * 
 * Supports:
 * 1. Point Update in O(log N)
 * 2. Prefix Sum Query in O(log N)
 * 3. Range Sum Query in O(log N)
 * 4. Linear Tree Construction in O(N)
 */
public class FenwickTree {
    private int size;
    private int[] tree;

    // Initialize an empty Fenwick Tree with given size (1-based internally)
    public FenwickTree(int n) {
        this.size = n;
        this.tree = new int[n + 1];
    }

    // Construct Fenwick Tree from an existing 0-based array in O(N) time
    public FenwickTree(int[] arr) {
        this.size = arr.length;
        this.tree = new int[size + 1];

        // Copy elements (1-based index mapping)
        for (int i = 0; i < size; i++) {
            this.tree[i + 1] = arr[i];
        }

        // O(N) build: propagate current value to immediate parent
        for (int i = 1; i <= size; i++) {
            int parent = i + (i & -i);
            if (parent <= size) {
                this.tree[parent] += this.tree[i];
            }
        }
    }

    /**
     * Point update (1-based index): adds delta to element at index i
     * Time Complexity: O(log N)
     */
    public void update(int i, int delta) {
        while (i <= size) {
            tree[i] += delta;
            i += (i & -i); // Add lowest set bit
        }
    }

    /**
     * Prefix sum query (1-based index): sum of elements from index 1 to i
     * Time Complexity: O(log N)
     */
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i); // Subtract lowest set bit
        }
        return sum;
    }

    /**
     * Range sum query (1-based index): sum of elements in range [l, r]
     * Time Complexity: O(log N)
     */
    public int rangeQuery(int l, int r) {
        if (l > r) return 0;
        return query(r) - query(l - 1);
    }

    // --- 0-based indexing convenience methods ---

    /**
     * Point update (0-based index)
     */
    public void update0Based(int index, int delta) {
        update(index + 1, delta);
    }

    /**
     * Prefix sum query (0-based index): sum from index 0 to index
     */
    public int query0Based(int index) {
        return query(index + 1);
    }

    /**
     * Range sum query (0-based index): sum in range [l, r]
     */
    public int rangeQuery0Based(int l, int r) {
        return rangeQuery(l + 1, r + 1);
    }

    public static void main(String[] args) {
        // Original array: {1, 2, 3, 4, 5}
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));

        FenwickTree bit = new FenwickTree(arr);

        // 1. Prefix sum queries (0-based)
        System.out.println("\n--- Prefix Sum Queries (0-based) ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Prefix sum up to index " + i + ": " + bit.query0Based(i));
        }

        // 2. Range sum queries (0-based)
        System.out.println("\n--- Range Sum Queries (0-based) ---");
        System.out.println("Range sum [0, 2] (expected 6): " + bit.rangeQuery0Based(0, 2));
        System.out.println("Range sum [1, 3] (expected 9): " + bit.rangeQuery0Based(1, 3));
        System.out.println("Range sum [0, 4] (expected 15): " + bit.rangeQuery0Based(0, 4));

        // 3. Point update (0-based)
        System.out.println("\n--- Point Update (0-based) ---");
        System.out.println("Adding +6 to index 2 (element changes from 3 to 9)...");
        bit.update0Based(2, 6);

        System.out.println("New range sum [0, 2] (expected 12): " + bit.rangeQuery0Based(0, 2));
        System.out.println("New range sum [1, 3] (expected 15): " + bit.rangeQuery0Based(1, 3));
        System.out.println("New range sum [0, 4] (expected 21): " + bit.rangeQuery0Based(0, 4));
    }
}
