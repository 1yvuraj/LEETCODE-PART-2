class Solution {
    int[] parent;

    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int c = 0;
        for (int[] nbr : connections) {
            int x = findPar(nbr[0]);
            int y = findPar(nbr[1]);
            if (x != y) {
                parent[y] = x;
            }
        }

        for (int i = 0; i < parent.length; i++) {
        if (parent[i]== i) {
                c++;
            }
        }
        return c-1;
    }

    public int findPar(int u) {
        return parent[u] == u ? u : (parent[u] = findPar(parent[u]));
    }
}
