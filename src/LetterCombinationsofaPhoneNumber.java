//LeetCode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
import java.util.*;
public class LetterCombinationsofaPhoneNumber {
    private static final String[] keys = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) return list;
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            list = combinations(keys[digits.charAt(i) - '0'], list);
        }
        return list;
    }
    public static List<String> combinations(String digit, List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++)
            for(String s : list) result.add(s+digit.charAt(i));
        return result;
    }
    public static void main(String[] args) {
        String digits = "426344";
        System.out.println(letterCombinations(digits));
    }
}
