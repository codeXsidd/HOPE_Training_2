package Graph;

public class union_find {
    static class Node {
        int[] parent;
        int[] rank;
        int count; // number of connected components

        Node(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            count = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find operation with Path Compression (O(alpha(n)) amortized)
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union operation by Rank
        void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);

            if (root_x != root_y) {
                if (rank[root_x] < rank[root_y]) {
                    parent[root_x] = root_y;
                } else if (rank[root_x] > rank[root_y]) {
                    parent[root_y] = root_x;
                } else {
                    parent[root_y] = root_x;
                    rank[root_x]++;
                }
                count--;
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Union-Find / Disjoint Set Union (DSU) ---");
        Node n = new Node(5);
        System.out.println("Initial components count: " + n.getCount());

        n.union(1, 2);
        n.union(2, 3);
        n.union(4, 5);

        System.out.println("Union(1, 2), Union(2, 3), Union(4, 5) completed.");
        System.out.println("Are 1 and 3 connected? " + n.isConnected(1, 3));
        System.out.println("Are 4 and 5 connected? " + n.isConnected(4, 5));
        System.out.println("Are 1 and 4 connected? " + n.isConnected(1, 4));

        if (n.find(4) == n.find(5)) {
            System.out.println("same component");
        } else {
            System.out.println("not same component");
        }

        System.out.println("Remaining connected components: " + n.getCount());
    }
}