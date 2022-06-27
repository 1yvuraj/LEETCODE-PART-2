class Solution {
    long l;

    public long countPairs(int n, int[][] edges) {
        l = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visit = new boolean[n];
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visit[i] == false) {
                l = 0;
                dfs(graph, visit, i);
                ans.add(l);
            }
        }
        long[] prefixSum = new long[ans.size()];
        prefixSum[prefixSum.length - 1] = ans.get(ans.size() - 1);
        for (int i = prefixSum.length - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + ans.get(i);
        }

        long sum = 0;
        for (int i = 0; i < ans.size()-1; i++) {
            
                sum+=ans.get(i)*prefixSum[i+1] ;
               
            
        }
        return sum;
    }

    public void dfs(ArrayList<Integer>[] graph, boolean[] visit, int src) {
        l++;
        visit[src] = true;
        for (int v : graph[src]) {
            if (!visit[v]) dfs(graph, visit, v);
        }
    }
}
