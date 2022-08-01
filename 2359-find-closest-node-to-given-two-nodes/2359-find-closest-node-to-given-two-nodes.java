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
        Arrays.fill(A, Integer.MAX_VALUE);
        Arrays.fill(B, Integer.MAX_VALUE);
        distace(graph, node1, node2, node1,A);
     distace(graph, node1, node2, node2,B);

        int min = (int) 1e9;

        int minDist = Integer.MAX_VALUE, resNode = -1;
        for (int i = 0; i <A.length; i++) {
            // node is not reacheable so discard
            System.out.println(B[i]);
            //if (A[i] == Integer.MAX_VALUE || B[i] == Integer.MAX_VALUE) continue;
            int tempDist = Math.max(A[i], B[i]);
            // take the node with min dist from node1 and node2
            if (tempDist < minDist) {
                minDist = tempDist;
                resNode = i;
            }
        }
        return resNode;
    }

    public void distace(ArrayList<ArrayList<Integer>> graph, int node1, int node2, int srs,int[]distace) {
        int n = graph.size();
        boolean[] visit = new boolean[n];
        LinkedList<Integer> q = new LinkedList<>();
        
        q.add(srs);
        int dist = 0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int rem = q.removeFirst();
                if (visit[rem]) continue;
                visit[rem] = true;
                distace[rem] = dist;
                for (int nbr : graph.get(rem)) {
                    if (!visit[nbr]) {
                        q.addLast(nbr);
                    }
                }
            }
            dist++;
        }
        
    }
}
