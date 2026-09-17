# Queue Data Structure Operations (Java)

This directory contains clear, modular Java implementations of different Queue types following the First-In, First-Out (**FIFO**) principle.

---

## 📑 Implementations

| File | Type | Underlying Structure | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`linear_queue.java`](linear_queue.java) | **Linear Queue** | Static Array | Simple pointer management (`front`, `rear`), resets when empty. Demonstrates memory boundary condition. |
| [`circular_queue.java`](circular_queue.java) | **Circular Queue** | Circular Array | Uses modulo arithmetic `(index + 1) % capacity` to wrap around and reuse dequeued slots efficiently. |
| [`linked_list_queue.java`](linked_list_queue.java) | **Linked List Queue**| Singly Linked List | Dynamic size, no capacity overflow. Enqueue at tail in $O(1)$, dequeue from head in $O(1)$. |

---

## ⏱️ Complexity Comparison

| Operation | Linear Queue | Circular Queue | Linked List Queue |
| :--- | :--- | :--- | :--- |
| **Enqueue** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Dequeue** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Peek** | $O(1)$ | $O(1)$ | $O(1)$ |
| **Space** | $O(N)$ (Fixed) | $O(N)$ (Fixed) | $O(N)$ (Dynamic) |
| **Memory Reuse** | ❌ (Slots before `front` wasted until reset) | ✅ (Wraps around to reuse freed space) | ✅ (Allocates/deallocates per node) |

---

## 💻 How to Compile & Run

From the root project directory:

```bash
# Compile all queue files
javac Queue/*.java

# Run Linear Queue
java Queue.linear_queue

# Run Circular Queue
java Queue.circular_queue

# Run Linked List Queue
java Queue.linked_list_queue
```
