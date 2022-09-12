class Solution {
    int[][] dir = { { 1, 0 }, { 0, 1 } };
    public int minCostClimbingStairs(int[]obstacleGrid) {
        int m = obstacleGrid.length;
        int[]dp = new int[m+1];
        return Math.min(help(0,m,dp, obstacleGrid),help(1,m,  new int[m], obstacleGrid));
    }

    public int help(int idx,int er,int[] dp, int[]obstacleGrid) {
       if(idx>=er)return 0;
       //if(idx>er)return (int)1e9;
       if(dp[idx]!=0)return dp[idx];
       int l=help(idx+1,er,dp,obstacleGrid);
        int r=help(idx+2,er,dp,obstacleGrid);
        return dp[idx]=Math.min(l,r)+obstacleGrid[idx];
    }
}
