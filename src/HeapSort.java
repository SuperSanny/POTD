//GFG: https://practice.geeksforgeeks.org/problems/heap-sort/1
import java.util.*;
public class HeapSort {
    static void buildHeap(int arr[], int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }
    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < n && arr[leftChild] > arr[largest]) largest = leftChild;
        if (rightChild < n && arr[rightChild] > arr[largest]) largest = rightChild;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    public static void heapSort(int arr[], int n) {
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
