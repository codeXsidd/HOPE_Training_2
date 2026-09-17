package Queue;

public class queue {
    private int[] a;
    private int front;
    private int rear;
    private int capacity;
    private int currentSize;

    // Constructor to initialize queue
    public queue(int size) {
        this.capacity = size;
        this.a = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Enqueue: Add an element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity;
        a[rear] = data;
        currentSize++;
        System.out.println(data + " enqueued to queue");
    }

    // Dequeue: Remove and return the front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        int temp = a[front];
        front = (front + 1) % capacity;
        currentSize--;
        return temp;
    }

    // Peek: View the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return a[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return currentSize == capacity;
    }

    // Return the number of elements in the queue
    public int size() {
        return currentSize;
    }

    // Display all elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % capacity;
            System.out.print(a[index] + (i < currentSize - 1 ? " -> " : ""));
        }
        System.out.println();
    }

    // Main method to test queue operations
    public static void main(String[] args) {
        queue q = new queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Try enqueuing when full
        q.enqueue(60);

        q.display();

        System.out.println("Front element (peek): " + q.peek());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.display();

        System.out.println("Queue size: " + q.size());
        System.out.println("Is empty: " + q.isEmpty());

        // Enqueue more to show circular wrapping efficiency
        q.enqueue(60);
        q.enqueue(70);
        q.display();
    }
}
