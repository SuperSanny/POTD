//LeetCode: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
import java.util.*;
public class NumberofLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        Arrays.fill(len,1);
        Arrays.fill(count, 1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    if(len[j] + 1 > len[i]){
                        len[i] = len[j] + 1;
                        count[i] = 0;
                    }
                    if(len[j] + 1 == len[i]) count[i] += count[j];
                }
            }
        }
        int maxLength = 0, result = 0;
        for(int l: len) maxLength = Math.max(maxLength,l);
        for(int i = 0; i < n; i++)
            if(len[i] == maxLength) result += count[i];

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}
