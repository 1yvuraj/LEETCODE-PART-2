class Graph {
    class pair implements  Comparable<pair>{
        int src;
        int val;
        pair(int src,int val){
            this.src=src;
            this.val=val;
        }
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }
    ArrayList<ArrayList<pair>>graph;
    public Graph(int n, int[][] edges) {
        graph=new ArrayList<>();
      
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]nbr:edges){
            graph.get(nbr[0]).add(new pair(nbr[1],nbr[2]));
            
        }
        
    }
    
    public void addEdge(int[] edge) {
       
            graph.get(edge[0]).add(new pair(edge[1],edge[2]));
            
        
    }
    
    public int shortestPath(int node1, int node2) {
      PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> a.val - b.val);
       q.add(new pair(node1,0));
        boolean[]visit=new boolean[graph.size()];
       
       
       while(q.size()>0){
          int size=q.size();
           while(size-->0){
               pair rem=q.poll();
               if(visit[rem.src])continue;
               visit[rem.src]=true;
               
               if(rem.src==node2){
                  
                   return rem.val;
               }
               for(pair nbr:graph.get(rem.src)){
                   if(!visit[nbr.src]){
                       q.add(new pair(nbr.src,nbr.val+rem.val));
                       
                   }
               }
           }
       }
       return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */