class Solution {
    int max = -1;
    public int longestCycle(int[] edges) {
        max = -(int) 1e9;
        boolean[] visit = new boolean[edges.length];
       for(int i:edges){
            HashMap<Integer, Integer> map = new HashMap<>();
            if (i==-1 ||visit[i]) continue;
            dfs(edges, i, 0, map, visit);
        }
        return max==-(int)1e9?-1:max;
    }

    public void dfs(int[] edges, int src, int dist, HashMap<Integer,Integer> map, boolean[] visit) {
        if (src == -1) return;
        if (visit[src]) {
            if (!map.containsKey(src)) return;
            max = Math.max(max, dist - map.get(src));
            return;
        }
        visit[src] = true;
        map.put(src, dist);
        dfs(edges, edges[src], dist + 1, map, visit);
    }
}
