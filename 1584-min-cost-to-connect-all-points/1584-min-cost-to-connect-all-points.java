class Solution {
    public class pair implements Comparable<pair> {
        int src;
        int wt;
        pair(int src, int wt) {
            this.src = src;
            
            this.wt = wt;
        }
        public int compareTo(pair o) {
            return this.wt - o.wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                graph[i].add(new pair(j, distace(points, i, j)));
                 graph[j].add(new pair(i, distace(points, i, j)));
                
            }
        }
        boolean[] vis = new boolean[n];
        int cost = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0));
        while (pq.size() != 0) {
            pair p = pq.remove();
            if (vis[p.src]) continue;

            vis[p.src] = true;
            cost += p.wt;

            for (pair e : graph[p.src]) {
                if (!vis[e.src]) {
                    pq.add(new pair(e.src, e.wt));
                }
            }
        }
        return cost;
    }
    public int distace(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
