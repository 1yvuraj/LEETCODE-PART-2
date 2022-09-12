class Solution {
    public int fib(int n) {
        int[]dp=new int[n+1];
        return help(n,dp);
    }
     public int help(int n,int[]dp) {
        if(n==0)return dp[n]=0;
        if(n==1)return dp[n]=1;
        if(dp[n]!=0)return dp[n];
        int f1=help(n-1,dp)+help(n-2,dp);
        return dp[n]=f1;
    }
}