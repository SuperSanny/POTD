//GFG: https://practice.geeksforgeeks.org/problems/unique-frequencies-of-not/1
import java.util.*;
public class UniqueNumberofOccurrences {
    public static boolean isFrequencyUnique1(int n, int[] arr) { // another approach
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            list.add(entry.getValue());
        }
        Set<Integer> unique = new HashSet<>();
        boolean hasUnique = false;
        for(int value : list) {
            if(!unique.add(value)) {
                hasUnique = true;
                break;
            }
        }
        if(hasUnique) return false;
        else return true;
    }
    public static boolean isFrequencyUnique(int n, int[] arr) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        Set<Integer> unique = new HashSet<>(freq.values());
        return unique.size() == freq.size();
    }
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {1, 1, 2, 5, 5};
        boolean answer = isFrequencyUnique(N, arr);
        System.out.println(answer);
    }
}
