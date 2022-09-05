class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        Integer[][]dp=new Integer[3001][1001];
        return help( startPos,  endPos,  k,dp);
    }
    public int help(int startPos, int endPos, int k, Integer[][]dp) {
        if(startPos==endPos && k==0)return 1;
        if(k<0)return 0;
        if(dp[startPos+1000][k]!=null)return dp[startPos+1000][k] ;
        int l=help(startPos-1,endPos,k-1,dp);
        int r=help(startPos+1,endPos,k-1,dp);
       
        return dp[startPos+1000][k]=(l+r)%((int)1e9+7);
        
    }
}