class Solution {
    int[] parent;
    int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        parent=new int[n+1];
        rank=new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int count=n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    int x = findPar(i);
                    int y = findPar(j);
                    if (x != y) {
                        parent[x]=y;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public int findPar(int u) {
        return parent[u] == u ? u : (parent[u] = findPar(parent[u]));
    }

    // public void union(int s1, int s2) {
    //     if (rank[s1] < rank[s2]) {
    //         parent[s1] = s2;
    //     } else if (rank[s1] > rank[s2]) {
    //         parent[s2] = s1;
    //     } else {
    //         parent[s1] = s2;
    //         rank[s1]++;
    //     }
    // }
}
