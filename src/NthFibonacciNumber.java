//GFG: https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
import java.util.*;
public class NthFibonacciNumber {
    static int nthFibonacci(int n){
        int a = 1, b = 1, c = 0;
        int i = 2;
        if(n == 1 || n == 2) return 1;
        while(i++ <= n){
            c = (a + b)%1000000007;
            if(i == n) return c;
            a = b;
            b = c;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(nthFibonacci(n));
    }
}
