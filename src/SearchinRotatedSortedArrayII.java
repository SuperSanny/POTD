//LeetCode: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
import java.util.*;
public class SearchinRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            } else if(target > nums[mid]){
                start = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}
