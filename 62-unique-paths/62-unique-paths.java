class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dir = { { 1, 0 }, { 0, 1 } };
        int[][]dp=new int[m][n];
        return help(0, 0, m - 1, n - 1, dir,dp);
    }

    // public int help(int sr, int sc, int er, int ec, int[][] dir) {
    //     if (sr == er && sc == ec) return 1;
    //     int count = 0;
    //     for (int d = 0; d < dir.length; d++) {
    //         int r = sr + dir[d][0];
    //         int c = sc + dir[d][1];
    //         if (r >= 0 && c >= 0 && r <= er && c <= ec) {
    //             count += help(r, c, er, ec, dir);
    //         }
    //     }
    //     return count;
    // }

    public int help(int sr, int sc, int er, int ec, int[][] dir,int[][]dp) {
        for (int i = er; i >= 0; i--) {
            for (int j = ec; j >= 0; j--) {
                if (i == er && j == ec) 
                {
                    dp[i][j]= 1;
                    continue;
                }
                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c];
                    }
                }
                dp[i][j]=count;
            }
        }
        return dp[0][0];
    }
}
