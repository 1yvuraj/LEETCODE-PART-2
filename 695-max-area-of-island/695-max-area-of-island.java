class Solution {
    int max=-(int)1e9;
    int l=1;
    public int maxAreaOfIsland(int[][] grid) {
        int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][]visit=new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++)
        {
            
            for(int j=0;j<grid[i].length;j++){
                if(visit[i][j]==false && grid[i][j]==1){
                    l=1;
                    visit[i][j]=true;
                    dfs(i,j,visit,dir,grid);
                max=Math.max(max,l);
                }
            }
        }
        return max==-(int)1e9?0:max;
    }
    public void dfs(int sr,int sc,boolean[][]visit,int[][]dir,int[][]grid) {
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1 && visit[r][c]==false){
               visit[r][c]=true;
                l++;
               dfs(r,c,visit,dir,grid); 
            }
        }
    }
}