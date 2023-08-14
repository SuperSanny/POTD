//GFG: https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
import java.util.*;
public class NonRepeatingNumbers {
    public static int[] singleNumber(int[] nums) {
//        int[] ans = new int[2];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int num : nums){
//            if(map.containsKey(num)) map.put(num, 2);
//            else map.put(num, 1);
//        }
//        int i = 0;
//        for(int num : map.keySet()) {
//            if(map.get(num) == 1) ans[i++] = num;
//        }
//        Arrays.sort(ans);
//        return ans;
        int[] ans = new int[2];
        int i = 0;
        for(int x : nums) i ^= x;
        int rightmost_set_bit = i & ~(i-1);
        int a = 0, b = 0;
        for(int x : nums)
        {
            if((x&rightmost_set_bit)==0) a = a ^ x;
            else b = b ^ x;
        }
        ans[0] = a;
        ans[1] = b;
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int N = 2; // 2 * N + 2
        int[] arr = {1, 2, 3, 2, 1, 4};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
}
