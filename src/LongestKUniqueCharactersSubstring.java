//GFG: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
import java.util.*;
public class LongestKUniqueCharactersSubstring {
    public static int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, j = -1, res = -1;
        while(++j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size() > k){
                char ch = s.charAt(++i);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);
            }
            if(map.size() == k) res = Math.max(res, (j - i));
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestkSubstr(s, k));
    }
}
