class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        int ans = -(int)1e9;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis= new boolean[n][m];;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0) {
                    ans = Math.max(ans, help_rec(grid, i, j, n - 1, m - 1,vis));
                }
            }
        }
        return ans==-(int)1e9?0:ans;
    }
    public int help_rec(int[][] arr, int sr, int sc, int dr, int dc,boolean[][]visit) {
        
        int maxGold = 0;
        visit[sr][sc]=true;
        for(int[] d : dir) {
            int r = sr + d[0]; 
            int c = sc + d[1];
            if(r >=0 && c >= 0 && r <=dr && c <= dc  && arr[r][c] != 0 && visit[r][c]==false)                             {
                maxGold = Math.max(maxGold,help_rec(arr, r, c, dr, dc,visit));
            }
        }
         visit[sr][sc]=false;
        
        return maxGold+arr[sr][sc];
        
    }
}