class Solution {
    int l=0;
    int max=-(int)1e9;
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    l=1;
                    dfs(grid, i, j, dir);
                    max=Math.max(max,l);
                }
            }
        }
        return max==-(int)1e9?0:max;
    }
    public void dfs(int[][] grid, int sr, int sc, int[][] dir) {
        grid[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                l++;
                dfs(grid, r, c, dir);
            }
        }
    }
}