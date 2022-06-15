class Solution {
    public class pair{
        int v;
        int colour;
        pair(int v,int colour)
        {
            this.v=v;
            this.colour=colour;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int []visit=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(visit[i]==0)
            {
                boolean b= bfs(graph,visit,i);
                if(b==false)
                {
                    return false;
                }
            }
            
        }
        return true;
    }
    public boolean bfs(int[][] graph,int[]visit,int v) {
        LinkedList<pair>list=new LinkedList<>();
        list.addLast(new pair(v,1));
        while(list.size()>0)
        {
           pair rem=list.removeFirst();
           if(visit[rem.v]!=0)
           {
               int old=visit[rem.v];
               int n=rem.colour;
               if(old!=n)
               {
                   return false;
               }
           }
            visit[rem.v]=rem.colour;
            for(int nbs:graph[rem.v]){
                if(visit[nbs]==0)
                list.addLast(new pair(nbs,rem.colour*-1));
            }
        }
        return true;
    }
}