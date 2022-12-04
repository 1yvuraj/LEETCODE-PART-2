class Solution {
    int ans=(int)1e9;
    public class pair implements Comparable<pair> {
        int v;
        int d;

        pair(int v, int d) {
            this.d = d;
            this.v = v;
        }

        public int compareTo(pair o) {
            return this.d - o.d;
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> graph = new ArrayList<>();
        boolean[]visied=new boolean[n+1];
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[]r:roads){
            graph.get(r[0]).add(new pair(r[1], r[2]));
            graph.get(r[1]).add(new pair(r[0], r[2]));
        }
        ans=Integer.MAX_VALUE;
        DFS(1,graph,visied);
        return ans;
    }

    public void DFS(int v,ArrayList<ArrayList<pair>> graph, boolean visited[]) {
        visited[v] = true;
        for (pair p : graph.get(v)) {
            // keep track of min edge weight
            ans = Math.min(ans, p.d);
            if (visited[p.v] == false) {
                DFS(p.v, graph, visited);
            }
        }
    }
}
