import java.util.*;

public class SubstringWithLargestVariance {
    public static int largestVariance(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int globalMax = 0;
        for(char ch1 : map.keySet()) {
            for(char ch2 : map.keySet()) {
                if(ch1 == ch2) continue;
                int ch1Freq = 0, ch2Freq = 0;
                int ch1Remain = map.get(ch1);
                for(char ch3 : s.toCharArray()) {
                    if(ch3 == ch1) {
                        ch1Freq++;
                        ch1Remain--;
                    }
                    if(ch3 == ch2) {
                        ch2Freq++;
                    }
                    if(ch2Freq < ch1Freq && ch1Remain > 0) {
                        ch2Freq = 0;
                        ch1Freq = 0;
                    }
                    if(ch1Freq > 0 && ch2Freq > 0) {
                        globalMax = Math.max(globalMax, ch2Freq - ch1Freq);
                    }
                }
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        String str = "aababbb";
        int ans = largestVariance(str);
        System.out.println(ans);
    }
}
