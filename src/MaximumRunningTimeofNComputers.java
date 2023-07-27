//LeetCode: https://leetcode.com/problems/maximum-running-time-of-n-computers/editorial/
import java.util.*;
public class MaximumRunningTimeofNComputers {
    public static long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long extra = 0;
        for (int i = 0; i < batteries.length - n; i++) {
            extra += batteries[i];
        }
        int[] live = Arrays.copyOfRange(batteries, batteries.length - n, batteries.length);
        for (int i = 0; i < n - 1; i++) {
            if (extra < (long)(i + 1) * (live[i + 1] - live[i])) {
                return live[i] + extra / (long)(i + 1);
            }
            extra -= (long)(i + 1) * (live[i + 1] - live[i]);
        }
        return live[n - 1] + extra / n;
    }
    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3, 3, 3};
        System.out.println(maxRunTime(n, batteries));
    }
}
