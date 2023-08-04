//LeetCode: https://leetcode.com/problems/word-break/
import java.util.*;
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i<=n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak(s, list));
    }
}
