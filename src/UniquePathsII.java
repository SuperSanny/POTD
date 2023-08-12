//LeetCode: https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else{
                    if(i > 0) dp[i][j] += dp[i-1][j];
                    if(j > 0) dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
