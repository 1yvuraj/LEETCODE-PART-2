class Solution {
    int idx ;

    public int[] findOrder(int n, int[][] prerequisites) {
        idx=n-1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] arr : prerequisites) {
            graph[arr[1]].add(arr[0]);
        }
        int[] visit = new int[n];
        int[] arr = new int[n];
        boolean cycle = false;
        for (int i = 0; i < graph.length; i++) {
            if (visit[i] == 0) cycle = cycle || dfs(i, graph, visit, arr);
        }
        if(!cycle) return arr;
        return new int[0];
    }

    public boolean dfs(int src, ArrayList<Integer>[] graph, int[] visit, int[] arr) {
        visit[src] = 1;
        boolean icycle = false;
        for (int nbr : graph[src]) {
            if (visit[nbr] == 0) {
                icycle = icycle || dfs(nbr, graph, visit,arr);
            } else if (visit[nbr] == 1) {
                return true;
            }
        }
        visit[src] = 2;
        arr[idx--] = src;
        return icycle;
    }
}
