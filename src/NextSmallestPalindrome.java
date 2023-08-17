//GFG: https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1
import java.util.*;
public class NextSmallestPalindrome {
    static Vector<Integer> generateNextPalindrome(int num[], int n) {
        int i = (n-1)/2;
        int j = n/2;
        boolean bool = isNine(num,n);
        if(bool) {
            Vector<Integer> v = new Vector<Integer>(n+1);
            for(int k=0; k<n+1; k++){
                if(k == 0 || k == n) v.add(1);
                else v.add(0);
            }
            return v;
        }
        boolean flag = Is(num);
        while(i>=0){
            if(flag){
                if(num[i] == 9){
                    num[i] = 0;
                    flag = true;
                } else{
                    num[i] ++;
                    flag = false;
                }
            }
            num[j++] = num[i--];
        }
        Vector<Integer> v = new Vector<Integer>(n);
        for(int k = 0; k<n; k++){
            v.add(num[k]);
        }
        return v;
    }
    private static boolean Is(int[] num) {
        int n = num.length;
        int i = (n-1)/2;
        int j = n/2;
        while(i>=0){
            if(num[i] < num[j]) return true;
            else if(num[i] > num[j]) return false;
            i--;
            j++;
        }
        return true;
    }
    private static boolean isNine(int[] num, int n) {
        for(int i=0; i<n; i++) {
            if(num[i]!=9) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int N = 11;
        int[] arr = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        Vector<Integer> v = generateNextPalindrome(arr, N);
        System.out.println(Collections.singletonList(v));
    }
}
