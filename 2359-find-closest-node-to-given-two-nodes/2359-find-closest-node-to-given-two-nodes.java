class Solution {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] A = new int[n];
        int[] B = new int[n];
        distace(edges, node1, node2, node1, A);
        distace(edges, node1, node2, node2, B);

        int min = (int) 1e9;

        int minDist = Integer.MAX_VALUE, resNode = -1;
        for (int i = 0; i < A.length; i++) {
            // node is not reacheable so discar
            int tempDist = Math.max(A[i], B[i]);
            // take the node with min dist from node1 and node2
            if (tempDist < minDist) {
                minDist = tempDist;
                resNode = i;
            }
        }
        return resNode;
    }

    public int[] distace(int[] edges, int node1, int node2, int srs, int[] distace) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> {
                return a[1] - b[1];
            }
        );
        Arrays.fill(distace, Integer.MAX_VALUE);
        q.add(new int[] { srs, 0 });
        int dist = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] rem = q.remove();
                if (visit[rem[0]]) continue;
                visit[rem[0]] = true;
                distace[rem[0]] = rem[1];
                int nbr = edges[rem[0]];
                if (nbr != -1 && distace[nbr]==Integer.MAX_VALUE) {
                    q.add(new int[] { nbr, rem[1] + 1 });
                }
            }
        }
        return distace;
    }
}
