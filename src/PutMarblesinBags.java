import java.util.*;

//Leetcode: https://leetcode.com/problems/put-marbles-in-bags/editorial/
public class PutMarblesinBags {
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length, min = 0, max = 0;
        if (k == 1 || k == n) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            list.add(weights[i] +weights[i+1]);
        }
        Collections.sort(list);
        long ans = 0l;
        for (int i = 0; i < k - 1; i++) {
            ans += list.get(n - 2 - i) - list.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        long ans = putMarbles(weights, k);
        System.out.println(ans);
    }

}
