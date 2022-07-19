class Solution {
    int max = -(int) 1e9;

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        boolean[][] visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ( grid[i][j] == 1) {
                    grid[i][j] = 0;
                    
                    max = Math.max(max,dfs(i, j, dir, grid));
                }
            }
        }
        return max == -(int) 1e9 ? 0 : max;
    }

    public int dfs(int sr, int sc, int[][] dir, int[][] grid) {
        int size = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                grid[r][c]=0;

                size += dfs(r, c,  dir, grid);
            }
        }
        return size + 1;
    }
}
