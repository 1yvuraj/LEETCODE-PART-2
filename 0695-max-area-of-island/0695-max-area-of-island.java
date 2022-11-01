class Solution {
    int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        
        int max=-(int)1e9;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                 max=Math.max(max,help(grid,i,j));
                }
            }
        }
        return max==-(int)1e9?0:max;
    }
    public int help(int[][] grid,int sr,int sc) {
        
        int size=0;
        for(int []d:dir){
            int r=sr+d[0];
            int c=sc+d[1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                grid[r][c]=0;
                size+=help(grid,r,c);
            }
        }
        return size+1;
    }
}