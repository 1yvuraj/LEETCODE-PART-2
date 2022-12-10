class Solution {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = edges.length-1;
        for (int i = 0; i <vals.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <=n; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        int max = -(int) 1e9;
        int ans = -(int) 1e9;
        for (int i = 0; i < vals.length; i++) {
            int sum = vals[i];
            ArrayList<Integer>list=graph.get(i);
            list.sort((a, b) -> vals[b]-vals[a]);
            max = sum;
            for (int s = 0; s < k && s<list.size(); s++) {
                sum += vals[list.get(s)];
                max = Math.max(max, sum);
            }
            ans = Math.max(ans, max);
        }
        return ans == -(int) 1e9 ? vals[0] : ans;
    }
}

// class Solution {
//     public int maxStarSum(int[] vals, int[][] edges, int k) {
//         int n = vals.length;
//         List<Integer>[] graph = new List[n];
        
//         for (int i = 0; i < n; i++) {
//             graph[i] = new ArrayList<Integer>();
//         }
        
//         for (int[] edge : edges) {
//             int a = edge[0], b = edge[1];
//             graph[a].add(b);
//             graph[b].add(a);
//         }
        
//         long res = Long.MIN_VALUE;
        
//         for (int i = 0; i < n; i++) {
//             List<Integer> curr = graph[i];
            
//             curr.sort((a, b) -> vals[b]-vals[a]);
            
//             long max = vals[i], sum = vals[i];
            
//             for (int j = 0; j < k && j < curr.size(); j++) {
//                 sum += vals[curr.get(j)];
//                 max = Math.max(max, sum);
//             }
            
//             res = Math.max(res, max);
//         }
        
//         return (int) res;
//     }
// }