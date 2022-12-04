class Solution {
    int ans=(int)1e9;
     public class pair  {
        int v;
        int d;

        pair(int v, int d) {
            this.d = d;
            this.v = v;
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
        LinkedList<Integer>pq=new LinkedList<>();
        pq.add(1);
        while (pq.size() > 0) {
            int size = pq.size();
            while (size-- > 0) {
                int rem = pq.removeFirst();
                if (visied[rem]) continue;
                visied[rem]=true;
                
                for (pair nbr : graph.get(rem)) {
                    pq.addLast(nbr.v);
                    ans=Math.min(ans, nbr.d);
                }
            }
        }
      
        return ans;
    }

}
