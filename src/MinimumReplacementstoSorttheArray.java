//LeetCode: https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
import java.util.*;
public class MinimumReplacementstoSorttheArray {
     public static long minimumReplacement(int[] nums) {
         long ans = 0;
         int n = nums.length;
         for(int i= n-2; i>=0; i--) {
             if(nums[i] <= nums[i+1]) continue;
             long numEle = (long)(nums[i] + nums[i+1] -1) / (long)nums[i+1];
             ans += numEle - 1;
             nums[i] = nums[i]/(int)numEle;
         }
         return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,6,7,3,4};
        System.out.println(minimumReplacement(nums));
    }
}
