package Queue;

/**
 * Linear Queue Implementation using an Array (Fixed Size).
 * Follows FIFO (First In, First Out) principle.
 */
public class linear_queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    // Constructor to initialize linear queue
    public linear_queue(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Enqueue: Add an element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("[OVERFLOW] Cannot insert " + data + " (Queue is full).");
            return;
        }
        if (front == -1) {
            front = 0; // First element being inserted
        }
        arr[++rear] = data;
        System.out.println("[ENQUEUED] " + data + " | front = " + front + ", rear = " + rear);
    }

    // Dequeue: Remove and return the front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("[UNDERFLOW] Queue is empty.");
            return -1;
        }
        int removed = arr[front++];
        System.out.println("[DEQUEUED] " + removed + " | front = " + front + ", rear = " + rear);

        // Reset pointers if queue becomes empty
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return removed;
    }

    // Peek: View front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("[INFO] Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    // Return the number of elements in the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }

    // Display current queue elements and pointers
    public void display() {
        if (isEmpty()) {
            System.out.println("[QUEUE] Currently empty.");
            return;
        }
        System.out.print("[QUEUE] (front: " + front + " -> rear: " + rear + "): ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + (i < rear ? " -> " : ""));
        }
        System.out.println();
    }

    // Main method to demonstrate Linear Queue
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       LINEAR QUEUE DEMONSTRATION       ");
        System.out.println("========================================");

        linear_queue q = new linear_queue(5);

        // Enqueue elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Attempt enqueue when full
        q.enqueue(60);

        System.out.println();
        q.display();

        System.out.println("\n[PEEK] Front element: " + q.peek());
        System.out.println("[SIZE] Current size: " + q.size());

        System.out.println("\n--- Performing Dequeue Operations ---");
        q.dequeue();
        q.dequeue();

        System.out.println();
        q.display();

        System.out.println("\n[SIZE] Size after dequeues: " + q.size());
        System.out.println("[PEEK] Front element now: " + q.peek());
    }
}
