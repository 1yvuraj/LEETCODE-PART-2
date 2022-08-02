class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1) {} else {
                graph.get(i).add(edges[i]);
            }
        }
        int[] A = new int[n];
        int[] B = new int[n];
        distace(graph, node1, node2, node1, A);
        distace(graph, node1, node2, node2, B);

        int min = (int) 1e9;

        int minDist = Integer.MAX_VALUE, resNode = -1;
        for (int i = 0; i < A.length; i++) {
            // node is not reacheable so discard
            System.out.println(B[i]);
            if (A[i] == -1 || B[i] == -1) continue;
            int tempDist = Math.max(A[i], B[i]);
            // take the node with min dist from node1 and node2
            if (tempDist < minDist) {
                minDist = tempDist;
                resNode = i;
            }
        }
        return resNode;
    }

    public int[] distace(ArrayList<ArrayList<Integer>> graph, int node1, int node2, int srs, int[] distace) {
        int n = graph.size();
        boolean[] visit = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
        return a[1] - b[1];
         });
        Arrays.fill(distace, -1);
        q.add(new int[]{ srs, 0 });
        int dist = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] rem = q.remove();
                if (visit[rem[0]]) continue;
                visit[rem[0]] = true;
                distace[rem[0]] = rem[1];
                for (int nbr : graph.get(rem[0])) {
                    if (!visit[nbr]) {
                        q.add(new int[] { nbr, rem[1] + 1 });
                    }
                }
            }
        }
        return distace;
    }
}
