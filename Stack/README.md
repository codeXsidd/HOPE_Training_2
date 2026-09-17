# Stack Data Structure Operations (Java)

This directory contains clean, modular Java implementations of the Stack data structure following the Last-In, First-Out (**LIFO**) principle.

---

## 📑 Implementations

| File | Type | Underlying Structure | Key Highlights |
| :--- | :--- | :--- | :--- |
| [`array.java`](array.java) | **Array Stack** | Fixed Array | Fixed capacity stack with boundary checks for `Stack Overflow` and `Stack Underflow`. |
| [`singly.java`](singly.java) | **Linked List Stack** | Singly Linked List | Dynamically sized stack using head-pointer push and pop. Grows without fixed capacity limit. |

---

## ⏱️ Complexity Comparison

| Operation | Array Stack | Linked List Stack |
| :--- | :--- | :--- |
| **Push** | $O(1)$ | $O(1)$ |
| **Pop** | $O(1)$ | $O(1)$ |
| **Peek** | $O(1)$ | $O(1)$ |
| **Space** | $O(N)$ (Fixed) | $O(N)$ (Dynamic per node) |

---

## 💻 How to Compile & Run

From the root project directory:

```bash
# Compile stack files
javac Stack/*.java

# Run Array-based Stack
java Stack.array

# Run Linked List-based Stack
java Stack.singly
```
