class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int max=-(int)1e9;
        LinkedList<Integer>q=new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){

                    max=Math.max(max,bfs(grid,i,j,dir));
                }
            }
        }
        return max==-(int)1e9?0:max;
    
       
    }
    public int bfs(int[][] grid,int i,int j,int[][]dir) {
        LinkedList<Integer>q=new LinkedList<>();
        q.addLast(i*grid[0].length+j);
        int l=1;
        grid[i][j]=0;
        while(q.size()>0){
            int size=q.size();
            
            while(size-->0){
                int rem=q.removeFirst();
                int sr=rem/grid[0].length;
                int sc=rem%grid[0].length;
                
                
                for(int d=0;d<dir.length;d++){
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];
                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length  && grid[r][c]==1){
                        l++;
                        grid[r][c]=0;
                        q.addLast(r*grid[0].length + c);
                    }
                }
            }
            
           
        }
        return l;
    }

    
}
