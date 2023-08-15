//GFG: https://practice.geeksforgeeks.org/problems/flip-bits0240/1
import java.util.*;
public class FlipBits {
    public static int maxOnes(int a[], int n) {
        int max = 0, sum = 0;
        for(int i=0; i<n; i++) {
            if(a[i] == 0) sum++;
            else sum --;
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        for(int i=0; i<n; i++) max += a[i];
        return max;
    }
    public static void main(String[] args) {
        int N = 7;
        int[] A = {1, 0, 0, 1, 0, 0, 1};
        System.out.println(maxOnes(A, N));
    }
}
