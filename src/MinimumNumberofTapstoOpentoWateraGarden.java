//LeetCode: https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class MinimumNumberofTapstoOpentoWateraGarden {
    public static int minTaps(int n, int[] ranges) {
        int min = 0, max = 0, open = 0;
        while(max < n) {
            for(int i = 0; i < ranges.length; i++){
                if(i-ranges[i]<=min && i+ranges[i] > max) max = i+ranges[i];
            }
            if(min == max) return -1;
            open++;
            min = max;
        }
        return open;
    }

    public static void main(String[] args) {
        int n = 5, ranges[] = {3,4,1,1,0,0};
        System.out.println(minTaps(n, ranges));
    }
}
