//Leetcode : https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/description/
import java.util.*;
public class MaximumNumberofAchievableTransferRequests {
    static int ans = 0;
    static void maxRequest(int[][] requests, int n, int index, int count, int[] buildings){
        if(index == requests.length) {
            for (int i = 0; i < n; i++) {
                if (buildings[i] != 0) return;
            }
            ans = Math.max(ans, count);
            return;
        }
        int from = requests[index][0];
        int to = requests[index][1];

        buildings[from]--;
        buildings[to]++;
        maxRequest(requests, n, index+1, count+1, buildings);

        buildings[from]++;
        buildings[to]--;
        maxRequest(requests, n, index +1, count, buildings);

    }
    public static int maximumRequests(int n, int[][] request){
        int[] bulidings = new int[n];
        maxRequest(request, n, 0, 0, bulidings);
        return ans;


    }
    public static void main(String[] args) {
//       int  n = 5;
//       int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int  n = 3;
        int[][] requests = {{0,0},{1,2},{2,1}};
        System.out.println(maximumRequests(n, requests));
    }
}
