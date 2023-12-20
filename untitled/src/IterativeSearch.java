public class IterativeSearch {
    public static void iterativeSelectionSort(int[] arr) {
        int n = arr.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }



    // Heapify the subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIdx = 2 * i + 1; // Left child index
        int rightChildIdx = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (leftChildIdx < n && arr[leftChildIdx] > arr[largest]) {
            largest = leftChildIdx;
        }

        // If right child is larger than largest so far
        if (rightChildIdx < n && arr[rightChildIdx] > arr[largest]) {
            largest = rightChildIdx;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Heap sort function
    public static void iterativeHeapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
}
