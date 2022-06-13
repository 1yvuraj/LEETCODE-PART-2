class Solution {

    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][]visit=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                
                if(visit[i][j]==false && grid[i][j]=='1'){
                    count++;
                help(grid,i,j,visit);
                }
                
            }
        }
        return count;
    }

    public void help(char[][] grid,int sr,int sc,boolean[][]visit) {
        if (sr<0 || sc<0 || sr>=grid.length|| sc>=grid[0].length|| grid[sr][sc]=='0'||visit[sr][sc]==true)
            return ;
        visit[sr][sc]=true;
        help(grid, sr + 1, sc,visit);
        help(grid, sr, sc + 1,visit);
        help(grid, sr - 1, sc,visit);
        help(grid, sr , sc - 1,visit);
    }
}
