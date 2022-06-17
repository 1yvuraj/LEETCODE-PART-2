
class Solution {
    public class pair{
        int i;
        int j;
        boolean border;
        
        pair(int i,int j){
            this.i=i;
            this.j=j;
           
            
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        //help(grid, row, col, grid[row][col], color, visit);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) grid[i][j] = color;
            }
        }
        int selfcolour=grid[row][col];
        LinkedList<pair>list=new LinkedList<>();
        ArrayList<pair>al=new ArrayList<>();
        pair ans=new pair(row,col);
         ans.border=check(grid,row,col);
        list.addLast(ans);
        while(list.size()>0)
        {
            pair rem=list.removeFirst();
            if(visit[rem.i][rem.j]==true){
                continue;
            }
            
            al.add(rem);
            visit[rem.i][rem.j]=true;
            help(grid,rem.i-1,rem.j,selfcolour,color,visit,list);
            help(grid,rem.i,rem.j-1,selfcolour,color,visit,list);
            help(grid,rem.i+1,rem.j,selfcolour,color,visit,list);
            help(grid,rem.i,rem.j+1,selfcolour,color,visit,list);
            
            
        }
        for(pair p:al){
            if(p.border==true){
                grid[p.i][p.j]=color;
            }
        }
        return grid;
    }
    
    public void help(int[][] grid, int row, int col, int selfcolor, int color, boolean[][] visit,LinkedList<pair>list) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visit[row][col] || grid[row][col] != selfcolor) {
            return;
        }
        pair ans=new pair(row,col);
        ans.border=check(grid,row,col);
       list.addLast(ans);
    }
    public boolean check(int[][] grid, int row, int col) {
        if(row==0){
            return true;
        }else if(col==0)
        {
            return true;
        }else if(row==grid.length-1)
        {
            return true;
        }else if(col==grid[0].length-1)
        {
            return true;
        }else{
            int ol=grid[row][col];
            if(grid[row-1][col]!=ol){
                return true;
            }
            if(grid[row+1][col]!=ol){
                return true;
            }
            if(grid[row][col-1]!=ol){
                return true;
            }
            if(grid[row][col+1]!=ol){
                return true;
            }
        }
        return false;
       
    }
   
  
}
// class Solution {
//     public class Pair{
//         int i;
//         int j;
//         boolean border;
        
//         Pair(int i,int j){
//             this.i=i;
//             this.j=j;
//         }
//     }
//     public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
//         ArrayDeque<Pair> q=new ArrayDeque<>();
//         boolean[][] visited=new boolean[grid.length][grid[0].length];
//         ArrayList<Pair> al=new ArrayList<>();
        
//         Pair p=new Pair(row,col);
//         p.border=isBorder(grid,row,col);
//         q.add(p);
//         int oclr=grid[row][col];
//         while(q.size()>0){
//             Pair rem=q.remove();
//             if(visited[rem.i][rem.j]) continue;
//             visited[rem.i][rem.j]=true;
            
//             al.add(rem);
            
//            addNbr(rem.i+1,rem.j,grid,visited,q,oclr);
//            addNbr(rem.i-1,rem.j,grid,visited,q,oclr);
//            addNbr(rem.i,rem.j+1,grid,visited,q,oclr);
//            addNbr(rem.i,rem.j-1,grid,visited,q,oclr);
//         }
        
//         for(Pair pp:al){
//             if(pp.border==true){
//                 grid[pp.i][pp.j]=color;
//             }
//         }
//         return grid;
//     }
    
//     void addNbr(int i,int j,int[][] grid,boolean[][] visited,ArrayDeque<Pair> q,int oclr){
//         if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=oclr || visited[i][j]==true)
//             return;
//         Pair np=new Pair(i,j);
//         np.border=isBorder(grid,i,j);
//         q.add(np);
//     }
    
//     public boolean isBorder(int[][] grid,int i,int j){
//         if(i==0){
//             return true;
//         }
//         else if(j==0){
//             return true;
//         }
//         else if(i==grid.length-1)
//             return true;
//         else if(j==grid[0].length-1)
//             return true;
//         else {
//             int color=grid[i][j];
//             if(grid[i+1][j]!=color)
//                 return true;
//             else if(grid[i][j+1]!=color)
//                 return true;
//             else if(grid[i-1][j]!=color)
//                 return true;
//             else if(grid[i][j-1]!=color)
//                 return true;
//             else
//                 return false;
//         }
        
//     }
// }

