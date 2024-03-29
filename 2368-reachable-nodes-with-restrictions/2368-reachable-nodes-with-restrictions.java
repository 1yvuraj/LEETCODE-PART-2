class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] nbr : edges) {
            graph[nbr[0]].add(nbr[1]);
            graph[nbr[1]].add(nbr[0]);
        }
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(0);
        boolean[] visit = new boolean[n];
        for (int i = 0; i < restricted.length; i++) {
           visit[restricted[i]]=true;
        }
        
       
        int count = 0;
        while (q.size() > 0) {
            int rem = q.removeFirst();
            if (visit[rem]) continue;
           
            visit[rem] = true;
            ++count;
            for (int nbr : graph[rem]) {
                if (!visit[nbr]) {
                    // System.out.println(nbr);
                    q.addLast(nbr);
                }
            }
        }
        return count;
    }
}
