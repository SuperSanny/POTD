//GFG: https://practice.geeksforgeeks.org/problems/fraction-pairs-with-sum-1/1
import java.util.*;
public class Fractionpairswithsum1 {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        int count = 0;
        Map<String, Integer> fractionMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int gcd = gcd(numerator[i], denominator[i]);
            String fraction = (numerator[i] / gcd) + "/" + (denominator[i] / gcd);
            String diffFraction = (denominator[i] / gcd - numerator[i] / gcd) + "/" + (denominator[i] / gcd);
            if (fractionMap.containsKey(diffFraction)) {
                count += fractionMap.get(diffFraction);
            }
            fractionMap.put(fraction, fractionMap.getOrDefault(fraction, 0) + 1);
        }
        return count;
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        int N = 5;
        int[] numerator = {3, 1, 12, 81, 2};
        int[] denominator = {9, 10, 18, 90, 5};
        System.out.println(countFractions(N, numerator, denominator));
    }
}
