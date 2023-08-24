//GFG: https://practice.geeksforgeeks.org/problems/multiply-two-strings/1
import java.util.*;
public class MultiplyTwoStrings {
    public static String multiplyStrings(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int a = s1.charAt(0) == '-' ? -1 : 0;
        int b = s2.charAt(0) == '-' ? -1 : 0;
        int[] arr = new int[n1+n2];
        for(int i = n1-1; i >= 0; i--) {
            int k = i+n2;
            if(s1.charAt(i) != '-'){
                int carry = 0;
                for(int j = n2-1; j >= 0; j--){
                    if(s2.charAt(j) != '-'){
                        int x = (s1.charAt(i)-'0') * (s2.charAt(j)-'0') + carry + arr[k];
                        arr[k] = x%10;
                        carry = x/10;
                        k--;
                    }
                }
                if(carry > 0) arr[k] = carry;
            }
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n1+n2; i++){
            while(i<n1+n2 && flag && arr[i] == 0) i++;
            flag = false;
            if(i < n1+n2) sb.append(arr[i]);
        }
        String str = sb.toString();
        if(a<0 && b>=0 || a>=0 && b<0) str = "-"+str;
        if(str.isEmpty()) return "0";
        return str;
    }

//    public static String multiplyStrings(String s1,String s2) {
//        long num1 = getNumber(s1);
//        long num2 = getNumber(s2);
//        long mul = num1 * num2;
//        return ""+mul;
//    }
//    public static long getNumber(String s){
//        boolean isNegative = false;
//        long num = 0;
//        for(int i=0;i<s.length();i++) {
//            if(s.charAt(i) == '-') isNegative = true;
//            else num = (num * 10) + (s.charAt(i) - '0');
//        }
//        if(isNegative) num *= -1;
//        return num;
//    }
    public static void main(String[] args) {
        String s1 = "110", s2 = "-20";
        System.out.println(multiplyStrings(s1,s2));
    }
}
