//LeetCode: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
import java.util.*;
public class MinimizetheMaximumDifferenceofPairs {
    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        int result = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(validPair(nums, mid) >= p) {
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static int validPair(int[] nums, int maxDiff) {
        int prev = 0, count = 0;
        while (prev < nums.length-1){
            if(nums[prev + 1] - nums[prev] <= maxDiff){
                count++;
                prev++;
            }
            prev++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4,2,1,2};
        int p = 1;
        System.out.println(minimizeMax(nums, p));
    }
}
