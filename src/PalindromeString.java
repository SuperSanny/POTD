//GFG: https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
import java.util.*;
public class PalindromeString {
    static int isPalindrome(String S) {
        StringBuilder sb = new StringBuilder(S);
        sb.reverse();
        if(sb.toString().equals(S)) return 1;
        return 0;
        // another
//        int start = 0, end = S.length()-1;
//        while(start <= end){
//            if(S.charAt(start) != S.charAt(end)) return 0;
//            start++;
//            end--;
//        }
//        return 1;
    }
    public static void main(String[] args) {
        String s = "abbaa";
        System.out.print(isPalindrome(s));
    }
}
