//GFG: https://practice.geeksforgeeks.org/problems/largest-prime-factor2601/1
import java.util.*;
public class Largestprimefactor {
    static long largestPrimeFactor(int N) {
        long prime = -1;
        while(N%2 == 0){
            prime = 2;
            N /= 2;
        }
        for(int i = 3; i<=Math.sqrt(N); i+=2){
            while(N%i == 0){
                prime = i;
                N /= i;
            }
        }
        if(N > 2) prime = N;
        return prime;
    }
    public static void main(String[] args) {
        int N = 415;
        System.out.println(largestPrimeFactor(N));
    }
}
