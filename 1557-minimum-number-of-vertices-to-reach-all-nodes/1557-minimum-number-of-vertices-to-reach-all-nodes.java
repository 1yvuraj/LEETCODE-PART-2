// class Solution {
//     public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//         boolean[] visit = new boolean[n];
//         ArrayList<Integer> ans = new ArrayList<>();
//         boolean b = false;
//         for (int i = 0; i < n; i++) {
//             if (!visit[i]) {
//                 dfs(n, edges, visit, i);
//                 b = false;
//                 for (int j = 0; j < visit.length; j++) {
//                     if (visit[j] != true) {
//                         ans.add(j);
//                         b = true;
//                     }
//                 }
//                 if (b) return ans;
//             }
//         }
//         return ans;
//     }

//     public void dfs(int n, List<List<Integer>> edges, boolean[] visit, int src) {
//         visit[src] = true;
//         for (int nbr : edges.get(src)) {
//             if (!visit[nbr]) {
//                 dfs(n, edges, visit, nbr);
//             }

//         }
//     }
// }

class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count = new int[n];
        for (List<Integer> nbr : edges) {
            int u=nbr.get(0);
            int v=nbr.get(1);
            
            count[v]++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
