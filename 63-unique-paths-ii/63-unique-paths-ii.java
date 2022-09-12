class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 } };
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)return 0;
        int[][] dp = new int[m][n];
        return help(0, 0, m - 1, n - 1, dp,obstacleGrid);
    }
    public int help(int SR, int SC, int ER, int EC, int[][] dp,int[][]obstacleGrid) {
        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (sr == ER && sc == EC) {
                    dp[sr][sc] = 1;
                    continue;
                }
                int count = 0;
                for (int[] d : dir) {
                    int r = sr + d[0];
                    int c = sc + d[1];
                    if (r >= 0 && c >= 0 && r <= ER && c <= EC  && obstacleGrid[r][c]!=1) {
                        count += dp[r][c];
                    }
                }
                dp[sr][sc] = count;
            }
        }
        return dp[SR][SC];
    }
}