//LeetCode: https://leetcode.com/problems/number-of-music-playlists/
import java.util.*;
public class NumberofMusicPlaylists {
    public static int numMusicPlaylists(int n, int goal, int k) {
        int MOD = (int)1e9 + 7;
        var dp = new long[n + 1];
        dp[1] = n;
        for (int i = 2; i <= goal; i++) {
            for (int j = Math.min(n, i); j > 0; j--)
                dp[j] = (dp[j-1] * (n-j+1) + dp[j] * Math.max(j-k, 0)) % MOD;
        }
        return (int)dp[n];
    }
    public static void main(String[] args) {
        int n = 3, goal = 3, k = 1;
        System.out.println(numMusicPlaylists(n, goal, k));
    }
}
