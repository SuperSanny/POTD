//GFG: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
import java.util.*;
public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int sum=0, start=0;
        ArrayList<Integer> li = new ArrayList<>();
        for(int i=0; i<n; i++){
            sum += arr[i];
            while(sum>s){
                sum -= arr[start];
                start++;
            }
            if(sum == s && sum != 0){
                li.add(start + 1);
                li.add(i+1);
                return li;
            }
        }
        li.add(-1);
        return li;
    }
    public static void main(String[] args) {
        int N = 5, S = 12;
        int[] A = {1,2,3,7,5};
        System.out.println(subarraySum(A, N, S));
    }
}
