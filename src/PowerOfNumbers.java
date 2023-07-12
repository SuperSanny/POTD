//GFG: https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
import java.util.*;
public class PowerOfNumbers {
    static int MOD = 1000000007;
    static long power(int N,int R)
    {
        if(R == 0) return 1;
        long temp = power(N,R/2);
        long rem = (temp * temp) % MOD;
        if(R % 2 == 1) return rem = (rem * N) % MOD;
        return rem;
    }
    static int reverse(int N){
        int rev = 0;
        while(N > 0) {
            int digit = N % 10;
            rev = rev * 10 + digit;
            N /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int N = 6;
        long ans = power(N, reverse(N));
        System.out.println(ans);
    }
}
