//GFG: https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1
import java.util.*;
public class NonRepeatingCharacter {
    static char nonrepeatingCharacter(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Character c : S.toCharArray()) {
            if(map.get(c) == 1) return c;
        }
        return '$';
    }
    public static void main(String[] args) {
        String S = "zxvczbtxyzvy";
        System.out.println(nonrepeatingCharacter(S));
    }
}
