class Solution {
    int mod=(int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int []dp=new int[high+1];
        Arrays.fill(dp,-1);
        int count=0;
       for(int i=low;i<=high;i++){
           count=count%mod+help(i,zero,one,dp)%mod;
       }
        return count%mod;
        
    }
    public int help(int i, int zero, int one,int[]dp) {
        if(i==0)return 1;
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i]=(help(i-zero,zero,one,dp)%mod+help(i-one,zero,one,dp)%mod)%mod;
    }
}