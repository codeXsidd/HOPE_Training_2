package Stack;

public class array {
    private int[] a;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    public array(int size) {
        this.capacity = size;
        this.a = new int[capacity];
        this.top = -1;
    }

    // Push: Insert element onto the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + data);
            return;
        }
        a[++top] = data;
        System.out.println(data + " pushed onto stack");
    }

    // Pop: Remove and return the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1;
        }
        int popped = a[top--];
        return popped;
    }

    // Peek: View the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return a[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Return the current size of the stack
    public int size() {
        return top + 1;
    }

    // Display all elements from top to bottom
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top -> bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(a[i] + (i > 0 ? " -> " : ""));
        }
        System.out.println();
    }

    // Main method to test array-based stack
    public static void main(String[] args) {
        array stack = new array(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Try pushing when full
        stack.push(60);

        stack.display();

        System.out.println("Top element (peek): " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Stack size: " + stack.size());
        System.out.println("Is empty: " + stack.isEmpty());
    }
}
