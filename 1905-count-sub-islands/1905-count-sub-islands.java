class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        int ans = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(i, j, dir, grid1,grid2)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean dfs(int sr, int sc, int[][] dir, int[][] grid1,int[][] grid2) {
        
        boolean res =true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < grid2.length && c < grid2[0].length && grid2[r][c] == 1) {
                grid2[r][c] = 0;

                res = dfs(r, c, dir, grid1,grid2)&&res;
            }
        }
        return res && (grid1[sr][sc]==1);
    }
}
