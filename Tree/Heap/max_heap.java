package Tree.Heap;

import java.util.Arrays;

public class max_heap {
    private int[] a = new int[100];
    private int size = 0;

    // Insert a new element into the max heap
    public void insert(int data) {
        // Dynamically resize array if capacity is reached
        if (size == a.length) {
            a = Arrays.copyOf(a, a.length * 2);
        }
        a[size] = data;
        size++;
        heap_up(size - 1);
    }

    // Restore max-heap property upwards from given index
    private void heap_up(int index) {
        while (index > 0) {
            int p = (index - 1) / 2;
            if (a[p] >= a[index]) {
                break;
            }
            int temp = a[index];
            a[index] = a[p];
            a[p] = temp;
            index = p;
        }
    }

    // Restore max-heap property downwards from given index
    private void heap_down(int index) {
        while (index < size) {
            int l = 2 * index + 1;
            int r = 2 * index + 2;
            if (l >= size) {
                break;
            }
            int max = l;
            if (r < size && a[r] > a[max]) {
                max = r;
            }
            if (a[index] >= a[max]) {
                break;
            }
            int temp = a[index];
            a[index] = a[max];
            a[max] = temp;
            index = max;
        }
    }

    // Remove and return the maximum element (root)
    public int remove() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int root = a[0];
        a[0] = a[size - 1];
        size--;
        if (size > 0) {
            heap_down(0);
        }
        return root;
    }

    // Return the maximum element without removing it
    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return a[0];
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of elements in the heap
    public int getSize() {
        return size;
    }

    // Display elements of the heap array
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        max_heap h = new max_heap();
        h.insert(50);
        h.insert(30);
        h.insert(40);
        h.insert(10);
        h.insert(20);
        h.insert(75);
        h.insert(5);

        System.out.print("Heap array after insertions: ");
        h.display();

        System.out.println("Removed maximum element: " + h.remove());

        System.out.print("Heap array after removal: ");
        h.display();
    }
}
