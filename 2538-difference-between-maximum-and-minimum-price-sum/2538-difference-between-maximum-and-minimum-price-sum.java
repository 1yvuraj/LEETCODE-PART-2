class Solution {

    public long maxOutput(int n, int[][] edges, int[] price) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] nbr : edges) {
            graph.get(nbr[0]).add(nbr[1]);
            graph.get(nbr[1]).add(nbr[0]);
        }
        long ans = -(int) 1e9;
        HashMap<String, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(graph, price, i, -1, map) - price[i]);
        }
        return ans;
    }

    public long dfs(ArrayList<ArrayList<Integer>> graph, int[] price, int root, int par, HashMap<String, Long> map) {
        long ans = 0;
        for (int nbr : graph.get(root)) {
            String x=root+" "+nbr;
            if (nbr != par) {   
               if(map.get(x)==null) map.put(x,dfs(graph, price, nbr, root, map));
                ans = Math.max(ans, map.get(x));
            }
        }

        return ans + price[root];
    }
}


    
//     private long dfs(int curr,int prev,List<List<Integer>> adj,Map<String,Long> dp,int[] prices) {
//         long max = 0;
//         for(int child:adj.get(curr)){
//             String x = curr+"-"+child;
//             if(child!=prev){
//                 if(dp.get(x)==null){
//                     dp.put(x,dfs(child,curr,adj,dp,prices));
//                 }
//                 max=Math.max(max,dp.get(x));
//             }
//         }
//         return max+prices[curr];
//     }
// }