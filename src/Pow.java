//LeetCode: https://leetcode.com/problems/powx-n/description/
import java.util.*;
public class Pow {
    public static double myPow(double x, int n) {
        return Math.pow(x, (double)n);
    }

    public static void main(String[] args) {
        double x = 2.0000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
