class Solution {
    int ans = 0;
    public int longestCycle(int[] edges) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = edges.length;
        int max = -(int) 1e9;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if(edges[i]!=-1)
            graph.get(i).add(edges[i]);
        }
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, graph, visit, stack);
            }
        }
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ngraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if(edges[i]!=-1)
            ngraph.get(edges[i]).add(i);
        }
        visit = new boolean[n];
       
        while (stack.size() > 0) {
            int rem = stack.removeFirst();
            if (!visit[rem]) {
                ans = 0;
                dfs1(rem, ngraph, visit);
                max = Math.max(max, ans);
            }
        }
        return max==1?-1:max;
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visit, LinkedList<Integer> stack) {
        visit[src] = true;
        for (int v : graph.get(src)) {
            if (!visit[v]) {
                dfs(v, graph, visit, stack);
            }
        }
        stack.addFirst(src);
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visit) {
        visit[src] = true;
        ans++;
        for (int v : graph.get(src)) {
            if (!visit[v]) {
                dfs1(v, graph, visit);
            }
        }
    }
}
