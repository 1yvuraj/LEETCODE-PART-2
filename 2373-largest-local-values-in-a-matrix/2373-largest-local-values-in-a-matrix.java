class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][]ans=new int[grid.length-2][grid[0].length-2];
        
        for(int i=0;i<grid.length-2;i++){
            
            for(int j=0;j<grid[0].length-2 ;j++){
              ans[i][j]=help(grid,i,j);
            }
            
        }
        return ans;
    }
    public int help(int[][] grid,int row,int col) {
        int max=-(int)1e9;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                max=Math.max(max,grid[i][j]);
            }
        }
        return max;
    }
}