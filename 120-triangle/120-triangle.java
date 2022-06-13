class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [][]dp=new int[triangle.size()+1][];
        int n= triangle.size()-1;
        for(int i=0; i<=n; i++){
            dp[i] = new int[i+1];
            for(int j=0; j<=i; j++)
                dp[i][j] = -1;
        }
        return minimumTotals(triangle,0,0,dp);
    
    }
     public int minimumTotals(List<List<Integer>> triangle,int i,int j,int[][]dp) {
        if(i==triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1)
        {
           return dp[i][j];
        }
         int f1= minimumTotals(triangle,i+1,j,dp);
         int f2= minimumTotals(triangle,i+1,j+1,dp);
        
         return dp[i][j]=Math.min(f2,f1)+triangle.get(i).get(j);
    }
}