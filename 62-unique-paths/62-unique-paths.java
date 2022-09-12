class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m+1][n+1];
        return help(0,0,m-1,n-1,dp);
    }
    public int help(int sr, int sc,int er,int ec,int[][]dp) {
        if(sr==er && sc==ec) return 1;
        if(sr>er || sc>ec)return 0;
        if(dp[sr][sc]!=0)return dp[sr][sc] ;
        int down=help(sr+1,sc,er,ec,dp);
        int right=help(sr,sc+1,er,ec,dp);
        return dp[sr][sc]=down+right;
        
    }
}