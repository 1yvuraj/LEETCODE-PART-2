class Solution {
    int[][]dir={{-1,0},{0,-1},{0,1},{1,0}};
    public int islandPerimeter(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    for(int[]d:dir){
                        int r=i+d[0];
                        int c=j+d[1];
                        if(check(r,c,grid.length,grid[0].length))ans++;
                        else if(grid[r][c]==0)ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean check(int i,int j,int n,int m) {
       if (i==-1 || i==n || j==-1 ||j==m )return true;
       else return false;
    }
}