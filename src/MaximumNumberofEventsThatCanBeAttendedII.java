//Leetcode: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/
import java.util.*;
public class MaximumNumberofEventsThatCanBeAttendedII {
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int prevEventIndex = findPreviousEvent(events, i);
                int valueWithEvent = events[i - 1][2] + dp[prevEventIndex][j - 1];
                int valueWithoutEvent = dp[i - 1][j];
                dp[i][j] = Math.max(valueWithEvent, valueWithoutEvent);
            }
        }
        return dp[n][k];
    }
    static int findPreviousEvent(int[][] events, int currentIndex) {
        int start = events[currentIndex - 1][0];
        for (int i = currentIndex - 1; i >= 1; i--)
            if (events[i - 1][1] < start) return i;

        return 0;
    }
    public static void main(String[] args) {
        int[][] events = {{1,2,4}, {3,4,3}, {2,3,1}};
        int k = 2;
        int ans = maxValue(events,k);
        System.out.println(ans);
    }

}
