//LeetCode: https://leetcode.com/problems/minimum-penalty-for-a-shop/
import java.util.*;
public class MinimumPenaltyforaShop {
    public static int bestClosingTime(String customers) {
        int minP = 0, currP = 0, earH = 0;
        for(int i=0; i< customers.length(); i++) {
            char ch = customers.charAt(i);
            if(ch == 'Y') currP--;
            else currP++;
            if(currP < minP){
                earH = i+1;
                minP = currP;
            }
        }
        return earH;
    }
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }
}
