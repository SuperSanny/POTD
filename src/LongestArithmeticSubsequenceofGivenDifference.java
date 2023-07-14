//Leetcode: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
import java.util.*;
public class LongestArithmeticSubsequenceofGivenDifference {
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            longest = Math.max(longest, map.get(arr[i]));
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        int ans = longestSubsequence(arr, difference);
        System.out.println(ans);
    }
}
