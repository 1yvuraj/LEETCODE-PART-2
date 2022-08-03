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
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.addLast(source);
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int rem = q.removeFirst();
                if (visit[rem]) continue;
                visit[rem] = true;
                if (rem == destination) {
                    System.out.println(rem);
                    return true;
                }
                for (int nbr : graph.get(rem)) {
                    if (!visit[nbr]) {
                        q.addLast(nbr);
                    }
                }
            }
        }
        return false;
    }
}
