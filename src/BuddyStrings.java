//Leetcode : https://leetcode.com/problems/buddy-strings/
import java.util.*;
public class BuddyStrings {

    static boolean buddyStrings(String s, String goal){
        if (s.length() != goal.length()) return false;
        int diff1 = -1, diff2 = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diff1 == -1) diff1 = i;
                else if (diff2 == -1) diff2 = i;
                else return false;
            }
            set.add(s.charAt(i));
        }
        if (diff1 != -1 && diff2 != -1)
            return s.charAt(diff1) == goal.charAt(diff2) && s.charAt(diff2) == goal.charAt(diff1);
        if (diff1 != -1)
            return false;
        return set.size() < s.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String goal = sc.nextLine();
        boolean ans = buddyStrings(s, goal);
        System.out.println(ans);
    }
}
