//GFG: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
import java.util.*;
public class FirstNonRepeatingCharacterInaStream {
    public static String FirstNonRepeating(String A)
    {
        ArrayList<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : A.toCharArray()) {
            if (!map.containsKey(ch)) {
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                int index = list.indexOf(ch);
                if (index != -1)
                    list.remove(index);
            }
            sb.append(list.isEmpty() ? '#' : list.get(0));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String A = "aab";
        System.out.println(FirstNonRepeating(A));
    }
}
