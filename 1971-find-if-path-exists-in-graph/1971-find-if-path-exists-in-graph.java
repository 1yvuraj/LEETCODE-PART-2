class Solution {
    int[]parent;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent=new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int []nbr:edges){
            int x=findPar(nbr[0]);
            int y=findPar(nbr[1]);
            if(x!=y){
                parent[x]=y;
               
            }
        }
        
        
        
        return findPar(source)==findPar(destination);
        
    }
    public int findPar(int u) {
        return parent[u] == u ? u : (parent[u] = findPar(parent[u]));
    }
}

