//GFG: https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
import java.util.*;
public class LongestIncreasingSubsequence {
    static int longestSubsequence(int size, int a[]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for(int num : a){
            Integer ceil = map.ceilingKey(num);
            if(ceil == null) map.put(num, map.size() + 1);
            else if(num < ceil) {
                map.put(num, map.get(ceil));
                map.remove(ceil);
            }
            ans = Math.max(map.get(num), ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int N = 16;
        int[] A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        System.out.println(longestSubsequence(N, A));
    }
}
