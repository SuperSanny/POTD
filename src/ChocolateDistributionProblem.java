//GFG: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
import java.util.*;
public class ChocolateDistributionProblem {
    public static long findMinDiff (ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        long minDiff = (long) (Integer.MAX_VALUE);
        for(int i = 0; i <= n-m; i++) {
            minDiff = Math.min(minDiff,a.get(i+m-1) - a.get(i));
        }
        return minDiff;
    }
    public static void main(String[] args) {
        int N = 8, M = 5;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        System.out.println(findMinDiff(A, N, M));
    }
}
