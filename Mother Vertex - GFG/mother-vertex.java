// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




// class Solution
// {
//     //Function to find a Mother Vertex in the Graph.
//      static int c=0;
//     public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
//     {
//       boolean[]visit=new boolean[V];
//       LinkedList<Integer>stack=new LinkedList<>();
//       for(int i=0;i<V;i++)
//       {
//           if(!visit[i])
//           dfs(i,adj,visit,stack);
//       }
       
//       int ans= stack.removeFirst();
       
//       dfs1(ans,adj,visit);
//       System.out.println(c);
//       System.out.println(V);
//       if(c+1==V)
//       {
//           return ans;
//       }
//           return -1;
       
       
//     }
//   public  void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]visit,LinkedList<Integer>stack) {
//      visit[src]=true;   
     
//      for(int v:graph.get(src))
//      {
//          if(!visit[v]){
//              dfs(v,graph,visit,stack);
//          }
//      }
//      stack.addFirst(src);
//   }
//   public  void dfs1(int src,ArrayList<ArrayList<Integer>>graph,boolean[]visit) {
//      visit[src]=true;   
//      c++;
//      for(int v:graph.get(src))
//      {
//          if(!visit[v]){
//              dfs1(v,graph,visit);
//          }
//      }
     
//   }
// }
class Solution
{
    //Function to find a Mother Vertex in the Graph.
      int c=0;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
       boolean[]visit=new boolean[V];

       for(int i=0;i<V;i++)
       {
           if(!visit[i]){
              c=0;
           dfs1(i,adj,visit);
           if(c==V)
           {
               return i;
           }
           }
       }
       return -1;
       
       
      
       
       
    }
  
  public  void dfs1(int src,ArrayList<ArrayList<Integer>>graph,boolean[]visit) {
     visit[src]=true;   
     c++;
     for(int v:graph.get(src))
     {
         if(!visit[v]){
             dfs1(v,graph,visit);
         }
     }
     
  }
}