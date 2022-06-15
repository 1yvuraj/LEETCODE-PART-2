class Solution {
    public class pair{
        int level;
        int i;
        int j;
        pair(int level,int i,int j)
        {
            this.level=level;
            this.i=i;
            this.j=j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<pair>list=new LinkedList<>();
        int[][]arr=new int[mat.length][mat[0].length];
        boolean[][]visit=new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0)
                list.addLast(new pair(0,i,j));
            }
        }
        while(list.size()>0)
        {
            pair rem=list.removeFirst();
            if(rem.i<0 || rem.j<0 || rem.i>=mat.length || rem.j>=mat[0].length||visit[rem.i][rem.j]==true)
            {
                continue;
            }
            visit[rem.i][rem.j]=true;
            arr[rem.i][rem.j]=rem.level;
            list.addLast(new pair(rem.level+1,rem.i-1,rem.j));
            list.addLast(new pair(rem.level+1,rem.i,rem.j-1));
            list.addLast(new pair(rem.level+1,rem.i+1,rem.j));
            list.addLast(new pair(rem.level+1,rem.i,rem.j+1));
        }
        return arr;
    }
}