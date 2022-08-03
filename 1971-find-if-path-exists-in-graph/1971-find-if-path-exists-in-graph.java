class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        if (edges.length == 0) return true;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] visit = new boolean[n];

        visit = new boolean[n];
        dfs(graph, source, visit);
        if (visit[destination]) return true;

        return false;
    }

    public void dfs( ArrayList<ArrayList<Integer>> graph, int src, boolean[] visit) {
        visit[src] = true;
        for (int nbr : graph.get(src)) {
            if (!visit[nbr]) {
                dfs(graph, nbr, visit);
            }
        }
    }
}
