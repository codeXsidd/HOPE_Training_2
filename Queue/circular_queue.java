package Queue;

/**
 * Circular Queue Implementation using an Array.
 * Solves the memory wastage problem of Linear Queue by connecting rear to front circularly.
 */
public class circular_queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int currentSize;

    // Constructor to initialize circular queue
    public circular_queue(int size) {
        this.capacity = size;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == capacity;
    }

    // Enqueue: Insert element at circular rear
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("[OVERFLOW] Cannot insert " + data + " (Queue is full).");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        currentSize++;
        System.out.println("[ENQUEUED] " + data + " at index [" + rear + "] | size: " + currentSize + "/" + capacity);
    }

    // Dequeue: Remove and return element from circular front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("[UNDERFLOW] Queue is empty.");
            return -1;
        }
        int removed = arr[front];
        System.out.println("[DEQUEUED] " + removed + " from index [" + front + "] | remaining: " + (currentSize - 1));
        front = (front + 1) % capacity;
        currentSize--;
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

    // Return the current number of elements
    public int size() {
        return currentSize;
    }

    // Display circular queue elements in order from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("[QUEUE] Currently empty.");
            return;
        }
        System.out.print("[QUEUE] (front -> rear): ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + (i < currentSize - 1 ? " -> " : ""));
        }
        System.out.println(" | front index: " + front + ", rear index: " + rear);
    }

    // Main method demonstrating Circular Queue wrap-around
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      CIRCULAR QUEUE DEMONSTRATION      ");
        System.out.println("========================================");

        circular_queue cq = new circular_queue(5);

        // Fill the queue
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        // Attempting to enqueue when full
        cq.enqueue(60);

        System.out.println();
        cq.display();

        System.out.println("\n--- Dequeuing 2 elements to free up front slots ---");
        cq.dequeue();
        cq.dequeue();

        System.out.println();
        cq.display();

        System.out.println("\n--- Enqueuing new elements to show circular wrap-around ---");
        // These will wrap around into indices 0 and 1
        cq.enqueue(60);
        cq.enqueue(70);

        System.out.println();
        cq.display();

        System.out.println("\n[PEEK] Front element: " + cq.peek());
        System.out.println("[SIZE] Total elements: " + cq.size());
    }
}
