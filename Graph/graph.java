package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
    static class Edge {
        int connect;
        int weight;

        Edge(int c, int w) {
            connect = c;
            weight = w;
        }
    }

    static void add_edge(ArrayList<Edge>[] g, int i, int j, int w) {
        g[i].add(new Edge(j, w));
        g[j].add(new Edge(i, w));
    }

    // Breadth-First Search (BFS) Traversal
    static void bfs(ArrayList<Edge>[] g, int start) {
        boolean[] visited = new boolean[g.length];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS Traversal from vertex " + start + ": ");
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (Edge e : g[curr]) {
                if (!visited[e.connect]) {
                    visited[e.connect] = true;
                    q.add(e.connect);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) Traversal
    static void dfs(ArrayList<Edge>[] g, int start) {
        boolean[] visited = new boolean[g.length];
        System.out.print("DFS Traversal from vertex " + start + ": ");
        dfsHelper(g, start, visited);
        System.out.println();
    }

    private static void dfsHelper(ArrayList<Edge>[] g, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for (Edge e : g[curr]) {
            if (!visited[e.connect]) {
                dfsHelper(g, e.connect, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        add_edge(g, 0, 2, 3);
        add_edge(g, 1, 3, 5);
        add_edge(g, 3, 4, 4);
        add_edge(g, 0, 1, 2); // Connect 0 and 1

        System.out.println("--- Graph Adjacency List Representation ---");
        for (int i = 0; i < n; i++) {
            System.out.print(" vertex " + i + " --> ");
            for (Edge e : g[i]) {
                System.out.print("(" + e.connect + ", wt:" + e.weight + ") ");
            }
            System.out.println();
        }

        System.out.println();
        bfs(g, 0);
        dfs(g, 0);
    }
}