import java.util.HashSet;

//GFG: https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1
public class FindTripletsWithZeroSum {
    public static boolean findTriplets(int arr[] , int n)
    {
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -arr[i] - arr[j];
                if (set.contains(complement)) return true;
                set.add(arr[j]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {0, -1, 2, -3, 1};
        boolean ans = findTriplets(arr, n);
        System.out.println(ans);
    }
}
