//GFG: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1
import java.util.*;
public class NumberOfOccurrence {
    static int count(int[] arr, int n, int x) {
        int firstIndex = findFirstIndex(arr, n, x);
        if (firstIndex == -1) return 0;
        int lastIndex = findLastIndex(arr,n, x);
        return lastIndex - firstIndex + 1;
    }
    static int findFirstIndex(int[] arr, int n, int x){
        int start = 0, end = n-1, result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < x) start = mid + 1;
            else if(arr[mid] > x) end = mid - 1;
            else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }
    static int findLastIndex(int[] arr, int n, int x){
        int start = 0, end = n-1, result = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < x) start = mid + 1;
            else if(arr[mid] > x) end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 7, X = 2;
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(count(arr, N, X));
    }
}
