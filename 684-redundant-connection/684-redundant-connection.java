class Solution {
    int[] arr;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        arr = new int[edges.length+1];
        rank = new int[edges.length+1];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i;
        }
        for (int[] c : edges) {
            int row = c[0];
            int col = c[1];
            int src1 = find(row);
            int src2 = find(col);
            if (src1 != src2) {
                union(src1, src2);
            } else {
                ans[0] = row;
                ans[1] = col;
                return c;
            }
        }
        
        return null;
    }

    public int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        int temp = find(arr[x]);
        arr[x] = temp;
        return temp;
    }

    public void union(int x, int y) {
        if (rank[x] > rank[y]) {
            arr[y] = x;
        } else if (rank[x] < rank[y]) {
            arr[x] = y;
        } else {
            arr[x] = y;
            rank[x]++;
        }
    }
}
