// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to detect cycle in an undirected graph.
     public boolean dfs(int V, ArrayList<ArrayList<Integer>> graph,boolean[]visit,int src,int p) {
      visit[src]=true;
      for(int nbr:graph.get(src)){
          if(!visit[nbr]){
          if(dfs(V,graph,visit,nbr,src)){
              return true;
          }
          }else if(p!=nbr){
              return true;
          }
      }
      return false;
     }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
         boolean[]visit=new boolean[V];
         boolean iscycle=false;
        for(int i=0;i<V;i++){
          if(!visit[i]){
              iscycle= dfs(V,graph,visit,i,-1);
              if(iscycle){
                  return true;
              }
          }
           
        }
      return false;
    }
}
