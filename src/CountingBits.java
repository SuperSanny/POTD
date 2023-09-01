//LeetCode: https://leetcode.com/problems/counting-bits/?envType=daily-question&envId=2023-09-01
import java.util.*;
public class CountingBits {
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++){
            ans[i] = countOnes(i);
        }
        return ans;
    }
    public static int countOnes(int n) {
        int count = 0;
        while(n > 0){
            count += n & 1;
            n >>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
