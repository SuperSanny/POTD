import java.util.*;

//GFG: https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
public class SmallestPositiveMissingNumber {

    static int missingNumber(int[] arr, int size){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 1; i <= size; i++){
            if(map.getOrDefault(i, 0) == 0) return i;
        }
        return size+1;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        int ans = missingNumber(arr, n);
        System.out.println(ans);
    }
}
