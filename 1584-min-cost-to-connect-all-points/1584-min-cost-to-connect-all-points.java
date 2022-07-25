class Solution {
    int[]p;
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        ArrayList<int[]>graph=new ArrayList<>();
        p=new int[n];
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                graph.add(new int[]{distace(points,i,j),i,j});
                
            }
        }
        Collections.sort(graph,(a,b)->{
            return a[0]-b[0];
        });
        for(int i=0;i<p.length;i++)p[i]=i;
        int cost=0;
        for(int[]nbr:graph){
            int wt=nbr[0];
            int u=nbr[1];
            int v=nbr[2];
            int x=findPar(u);
            int y=findPar(v);
            if(x!=y){
                p[x]=y;
                cost+=wt;
            }
            
        }
        return cost;
            
        
    }
    public  int findPar(int u) {
        return p[u] == u ? u : (p[u] = findPar(p[u]));
    }

     public int distace(int[][] points,int i ,int j) {
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
        
    }
}