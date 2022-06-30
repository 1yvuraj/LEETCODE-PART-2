class Solution {
    int[] arr;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        arr = new int[edges.length+1];
        rank = new int[edges.length+1];
        for(int i=0;i<edges.length;i++){
            arr[i]=i;
            rank[i]=1;
        }
        for(int[]nbr:edges){
            int u=nbr[0];
            int v=nbr[1];
            int x=find(u);
            int y=find(v);
            if(x!=y){
                union(x,y);
            }else{
                return nbr;
            }
        }
        return null;
    }
    public int find(int x) {
       return arr[x]==x?x:(arr[x]=find(arr[x]));
    }
    public void union(int x,int y) {
       if(rank[x]>rank[y]){
           arr[y]=x;
       }else if(rank[x]>rank[y]){
           arr[x]=y;
       }else{
          arr[x]=y;
          rank[x]++;
       }
    }
}
