// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends

//User function Template for Java
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> graph)
    {
     LinkedList<Integer>stack=new LinkedList<>();
     boolean []visit=new boolean[v];
     for(int i=0;i<v;i++)
     {
         if(!visit[i]){
             dfs(i,graph,visit,stack);
         }
     }
     ArrayList<ArrayList<Integer>>ngraph=new ArrayList<>();
     for(int i=0;i<v;i++)
     {
         ngraph.add(new ArrayList<>());
     }
      for(int i=0;i<v;i++)
     {
         for(int nbr:graph.get(i)){
           ngraph.get(nbr).add(i);
         }
     }
     visit=new boolean[v];
     int ans=0;
     while(stack.size()>0){
         int rem=stack.removeFirst();
         if(!visit[rem]){
            
             dfs1(rem,ngraph,visit);
             ans++;
         }
     }
     return ans;
    }
    public static void dfs(int src,ArrayList<ArrayList<Integer>>graph,boolean[]visit,LinkedList<Integer>stack) {
     visit[src]=true;
     for(int v:graph.get(src))
     {
         if(!visit[v]){
             dfs(v,graph,visit,stack);
         }
     }
     stack.addFirst(src);
  }
  public static void dfs1(int src,ArrayList<ArrayList<Integer>>graph,boolean[]visit) {
     visit[src]=true;
     for(int v:graph.get(src))
     {
         if(!visit[v]){
             dfs1(v,graph,visit);
         }
     }
  }
}
