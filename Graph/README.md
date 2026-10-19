# Graph Data Structure & Algorithms (Java)

This directory contains clean, modular Java implementations of Graph representations, traversal algorithms (BFS & DFS), and Disjoint Set Union (Union-Find).

---

## 📑 Contents

| File | Type | Representation | Key Algorithms / Operations |
| :--- | :--- | :--- | :--- |
| [`graph.java`](graph.java) | **Weighted Undirected Graph** | Adjacency List (`ArrayList<Edge>[]`) | Graph construction, Breadth-First Search (BFS), Depth-First Search (DFS) |
| [`union_find.java`](union_find.java) | **Disjoint Set Union (DSU)** | Parent & Rank arrays | Path Compression, Union by Rank, connectivity queries, component counting |
| [`practice.java`](practice.java) | **Unweighted Graph** | Adjacency List (`ArrayList<Integer>[]`) | Lightweight vertex-edge adjacency list representation |

---

## 🔍 Detailed Explanations

### 1. Graph Traversals (`graph.java`)
- **Adjacency List**: Represents the graph using an array of `ArrayList<Edge>` where each `Edge` stores the neighbor vertex `connect` and edge weight `weight`.
- **Breadth-First Search (BFS)**:
  - Traverses the graph layer by layer using a FIFO `Queue` (`LinkedList`).
  - Marks visited vertices to prevent infinite cycles.
  - Time Complexity: $O(V + E)$ where $V$ is vertices and $E$ is edges.
- **Depth-First Search (DFS)**:
  - Explores as far as possible along each branch before backtracking using recursive calls.
  - Time Complexity: $O(V + E)$.

### 2. Disjoint Set Union / Union-Find (`union_find.java`)
- **Path Compression**: Flattens the tree during `find(x)` so all visited nodes point directly to the root:
  ```java
  int find(int x) {
      if (parent[x] != x) {
          parent[x] = find(parent[x]); // Path compression
      }
      return parent[x];
  }
  ```
- **Union by Rank**: Always attaches the shallower tree to the root of the deeper tree, keeping tree height bounded by $O(\log N)$.
- **Time Complexity**: Nearly constant $O(\alpha(N))$ amortized per operation, where $\alpha$ is the Inverse Ackermann function.

---

## ⏱️ Complexity Summary

| Data Structure / Algorithm | Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Adjacency List** | Add Edge | $O(1)$ | $O(V + E)$ |
| **Graph Traversal** | BFS / DFS | $O(V + E)$ | $O(V)$ |
| **Union-Find (DSU)** | Find (with path compression) | $O(\alpha(V))$ amortized | $O(V)$ |
| **Union-Find (DSU)** | Union (by rank) | $O(\alpha(V))$ amortized | $O(V)$ |
| **Union-Find (DSU)** | Connected Check | $O(\alpha(V))$ amortized | $O(1)$ auxiliary |

---

## 💻 How to Compile & Run

From the root project directory:

```bash
# Compile all Graph files
javac Graph/*.java

# Run Graph representation, BFS & DFS
java Graph.graph

# Run Union-Find / DSU
java Graph.union_find

# Run Graph practice
java Graph.practice
```
