class Solution {
    public class pair{
        int x;
        int y;
        int t;
        pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
        
    }
    public int orangesRotting(int[][] grid) {
       return  help(grid);
    }
    public int help(int[][] grid) {
        int fresh=0;
        LinkedList<pair>list=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                {
                    fresh++;
                }
                if(grid[i][j]==2){
                    list.addLast(new pair(i,j,0));
                }
            }
        }
       int time =0;
        while(list.size()>0)
        {
            pair rem=list.removeFirst();
            if( rem.x<0 || rem.y<0 || rem.x>=grid.length||rem.y>=grid[0].length || grid[rem.x][rem.y]==-1||grid[rem.x][rem.y]==0)
            {
                continue;
            }
            
            if(rem.t>time)
            {
                time=rem.t;
            }
            if(grid[rem.x][rem.y]==1){
                fresh--;
            }
            grid[rem.x][rem.y]=-1;
            list.addLast(new pair(rem.x+1,rem.y,rem.t+1));
            list.addLast(new pair(rem.x,rem.y+1,rem.t+1));
            list.addLast(new pair(rem.x-1,rem.y,rem.t+1));
            list.addLast(new pair(rem.x,rem.y-1,rem.t+1));
        }
        return fresh==0?time:-1;
    }
}
