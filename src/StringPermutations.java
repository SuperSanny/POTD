//GFG: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1
import java.util.*;
public class StringPermutations {
    public static ArrayList<String> permutation(String S) {
        ArrayList<String> result = new ArrayList<String>();
        char[] chars = S.toCharArray();
        permutationHelper(chars, 0, result);
        Collections.sort(result);
        return result;
    }
    private static void permutationHelper(char[] chars, int index, ArrayList<String> result) {
        if(index == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        for(int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permutationHelper(chars, index + 1, result);
            swap(chars, index, i);
        }
    }
    private static void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
    public static void main(String[] args) {
        String S = "AAA";
        System.out.println(permutation(S));
    }
}
