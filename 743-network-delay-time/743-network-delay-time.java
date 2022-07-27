class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]>[]graph=new ArrayList[n+1];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[]i:times){
            graph[i[0]].add(new int[]{i[1],i[2]});
        }
        return help(graph,k);
    }

    public int help(ArrayList<int[]>[]graph, int src) {
       int[]distace=new int[graph.length];
        boolean[]visit=new boolean[graph.length];
         for(int i=0;i<distace.length;i++){
            distace[i]=(int)1e9;
        }
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        return a[1] - b[1];
        });
       pq.add(new int[]{src,0});
        while(pq.size()>0){
            int[]arr=pq.remove();
            int s=arr[0],wsf=arr[1];
            if(visit[s])continue;
            visit[s]=true;
            distace[s]=wsf;
            for(int[]nbr:graph[s]){
                if(!visit[nbr[0]]){
                    pq.add(new int[]{nbr[0],wsf+nbr[1]});
                }
            }
            
        }
        int max=-(int)1e9;
        for(int i=1;i<distace.length;i++){
            if(distace[i]==(int)1e9)return -1;
             max=Math.max(max,distace[i]);
        }
        return max;
       
    }
}
