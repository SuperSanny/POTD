import java.util.Arrays;

//GFG: https://practice.geeksforgeeks.org/problems/quick-sort/1
public class QuickSort {
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {4, 1, 3, 9, 7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }
}
