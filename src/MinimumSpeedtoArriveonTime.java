//LeetCode: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
public class MinimumSpeedtoArriveonTime {
    public static int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour <= n - 1) return -1;
        int left = 1, right = (int) 1e7;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(dist, hour, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    private static boolean check(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i == dist.length - 1) time += (double) dist[i] / speed;
            else time += Math.ceil((double) dist[i] / speed);
        }
        return time <= hour;
    }
    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        System.out.println(minSpeedOnTime(dist, hour));
    }
}
