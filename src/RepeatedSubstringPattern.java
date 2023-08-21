//LeetCode: https://leetcode.com/problems/repeated-substring-pattern/
import java.util.*;
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        String r = t.substring(1, t.length() - 1);
        if (r.contains(s))
            return true;
        return false;
    }
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(repeatedSubstringPattern(s));
    }
}
