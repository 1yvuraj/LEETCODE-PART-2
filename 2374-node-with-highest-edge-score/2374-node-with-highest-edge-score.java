class Solution {
    public int edgeScore(int[] edges) {
        long[]edge=new long[edges.length];
        for(int i=0;i<edges.length;i++){
            edge[edges[i]]+=i;
        }
        long max=-(int)1e9;
        long ans=-1;
        for(int i=0;i<edge.length;i++){
            if(max<edge[i]){
                max=edge[i];
                ans=i;
            }
        }
        return (int)ans;
        
    }
}