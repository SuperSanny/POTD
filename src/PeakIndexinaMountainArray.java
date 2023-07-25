//LeetCode: https://leetcode.com/problems/peak-index-in-a-mountain-array/
import java.util.*;
public class PeakIndexinaMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start<end){
            int mid = start + (end-start) / 2;
            if(arr[mid]>arr[mid+1]) end = mid;
            else start = mid+1;
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
