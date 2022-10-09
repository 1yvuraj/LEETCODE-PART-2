class Solution {
    int[][]dir={{0,1},{1,0}};
    int mod=(int)Math.pow(10, 9) + 7;
    public int numberOfPaths(int[][] grid, int k) {
        mod=(int)1e9+7;
        Integer[][][]dp=new Integer[grid.length+1][grid[0].length+1][50];
       
        return (int)(help(grid,0,0,0,k,dp)%mod);
    }
    public int help(int[][] grid, int sr,int sc,int sum,int k,Integer[][][]dp) {
       if(sr==grid.length-1 && sc==grid[0].length-1){
           if((sum+grid[sr][sc])%k==0){
               return dp[sr][sc][sum%k]=1;
           }else
           return dp[sr][sc][sum%k]=0;
       }
        if(dp[sr][sc][sum%k]!=null)return dp[sr][sc][sum%k]%mod;
        int count=0;
        for(int d=0;d<dir.length;d++){
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length){
              count=(count%mod+help(grid,r,c,sum+grid[sr][sc],k,dp)%mod)%mod;
            }
        }
        return dp[sr][sc][sum%k]=count%mod;
        
    }
}