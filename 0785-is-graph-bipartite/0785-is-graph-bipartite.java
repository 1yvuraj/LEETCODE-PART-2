class Solution {
     class pair{
        int nbr;
        int colour;
        pair(int nbr,int colour){
            this.nbr=nbr;
            this.colour=colour;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int[]visit=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visit[i]==0){
                if(!bfs(graph,visit,i))return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int[]visit,int src) {
        LinkedList<pair>q=new LinkedList<>();
        q.addLast(new pair(src,1));
        while(q.size()!=0){
            pair rem=q.removeFirst();
            if(visit[rem.nbr]!=0){
                int old=visit[rem.nbr];
                int newcolour =rem.colour;
                if(old!=newcolour)return false;
               
            }
            visit[rem.nbr]=rem.colour;
            for(int nbr:graph[rem.nbr]){
                if(visit[nbr]==0){
                    q.addLast(new pair(nbr,rem.colour*-1));
                   
                }
            }
        }
        return true;
    }
}