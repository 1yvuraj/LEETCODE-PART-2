class Solution {
    int max = -(int) 1e9;
    int[] p;
    int[] rank;
    int ones = 0;

    public int maxAreaOfIsland(int[][] grid) {
        p = new int[grid.length * grid[0].length];
        rank = new int[grid.length * grid[0].length];
        int max = -(int) 1e9;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int x = find(i * grid[0].length + j);
                    for (int d = 0; d < dir.length; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                            int y = find(r * grid[0].length + c);
                            if (x != y) {
                                p[y] = x;
                                rank[x] += rank[y];
                            }
                        }
                    }
                    max = Math.max(max, rank[x]);
                }
            }
        }
        return max==-(int)1e9?0:max;
    }

    public int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }
}
