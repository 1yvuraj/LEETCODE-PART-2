class Solution {
    public int climbStairs(int n) {
       int[]dp=new int[n+1];
       return help(n,dp); 
    }
    public int help(int n,int[]dp) {
      if(n==0)return 1;
      if(n<0)return 0;
      if(dp[n]!=0)return dp[n];
      return dp[n]=help(n-1,dp)+help(n-2,dp);
    }
}