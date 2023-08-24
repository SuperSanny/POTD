//LeetCode: https://leetcode.com/problems/reorganize-string/
import java.util.*;
public class ReorganizeString {
    public static String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for(char c: s.toCharArray()) charCounts[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]- a[1]);
        for (int i=0; i < 26; i++){
            if(charCounts[i] > 0) pq.offer(new int[]{i+'a', charCounts[i]});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)){
                sb.append((char)first[0]);
                if(--first[1] > 0) pq.offer(first);
            } else {
                if(pq.isEmpty()) return "";
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if(--second[1] > 0) pq.offer(second);
                pq.offer(first);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
