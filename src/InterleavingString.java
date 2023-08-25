//LeetCode: https://leetcode.com/problems/interleaving-string/
import java.util.*;
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len3 != len1+len2) return false;
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{0, 0});
        boolean[][] visited = new boolean[len1 + 1][len2 + 1];
        while(!stack.empty()) {
            int[] indexes = stack.pop();
            int i = indexes[0], j = indexes[1];
            visited[i][j] = true;
            if(i == len1 && j == len2) return true;
            if(i < len1 && !visited[i+1][j] && s1.charAt(i) == s3.charAt(i + j)) stack.push(new int[] {i+1, j});
            if(j < len2 && !visited[i][j+1] && s2.charAt(j) == s3.charAt(i + j)) stack.push(new int[] {i, j+1});
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
