package MinHeap;

public class MinHeap {
    private int[] heap;
    private int maxsize;
    private int size;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.heap = new int[this.maxsize + 1];
    }

    // Position of parent node
    private int parent(int k) {
        return k/2;
    }

    // Position of left child
    private int leftChild(int k) {
        return (2*k);
    }

    // Position of right child
    private int rightChild(int k) {
        return (2*k + 1);
    }

    // Check if the node is leaf
    private boolean isLeaf(int k) {
        if(k >= (size/2) && k <= size) {
            return true;
        }
        return false;
    }

    // Swap two nodes of the heap
    private void swap(int i_k, int f_k) {
        int temp = heap[i_k];
        heap[i_k] = heap[f_k];
        heap[f_k] = temp;
    }

    // Heapify
    private void heapify(int k) {
        if(!isLeaf(k)) {
            if (heap[k] > heap[leftChild(k)] || heap[k] > heap[rightChild(k)]) {

                if (heap[leftChild(k)] < heap[rightChild(k)]) {
                    swap(k, leftChild(k));
                    heapify(leftChild(k));
                } else {
                    swap(k, rightChild(k));
                    heapify(rightChild(k));
                }
            }
        }
    }

    // Insert a node
    public void insert(int element) {
        if(size >= maxsize) {
            return;
        }
        heap[++size] = element;
        int current = size;

        while(heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Print heap
    public void print() {
        for(int i = 1; i <= size/2; i++) {
            System.out.println("Parent: " + heap[i]
            + " Left Child: " + heap[2*i]
            + " Right Child: " + heap[2*i + 1]);
            System.out.println();
        }
    }

    // Function to build min heap
    public void minHeap() {
        for(int i = (size /2); i >=1; i--) {
            heapify(i);
        }
    }

    // Remove and return the minimum element
    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        heapify(FRONT);
        return popped;
    }

    // Driver code
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();

        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
    }
}
