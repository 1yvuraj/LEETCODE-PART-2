class Solution {
    int[][]dir={{1,0},{0,1}};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        return help( 0,0,m - 1, n - 1, dp);
    }
    public int help( int sr,int sc,int er, int ec, int[][] dp) {
        if(sr==er && sc==ec)return 1;
        if(dp[sr][sc]!=0)return dp[sr][sc];
        int count=0;
        for(int []d:dir){
            int r=sr+d[0];
            int c=sc+d[1];
            if(r>=0 && c>=0 && r<=er && c<=ec){
                count+=help(r,c,er,ec,dp);
            }
        }
       return dp[sr][sc]=count;
    
    }
     
}
