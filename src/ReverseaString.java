//GFG: https://practice.geeksforgeeks.org/problems/reverse-a-string/1
import java.util.*;
public class ReverseaString {
    public static String reverseWord(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Geeks";
        System.out.println(reverseWord(s));
    }
}
