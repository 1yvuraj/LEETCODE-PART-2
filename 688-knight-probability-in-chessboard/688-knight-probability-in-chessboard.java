class Solution {
    int[][] dir = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n + 1][n + 1];
        return knightProbability_(n, k, row, column, dp);
    }

    public double knightProbability_(int n, int k, int row, int column, double[][][] dp) {
        if (k == 0) return 1.0;
        if (dp[k][row][column] != 0.0) return dp[k][row][column];
        double count = 0.0;
        for (int d = 0; d < 8; d++) {
            int r = row + dir[d][0];
            int c = column + dir[d][1];
            if (r >= 0 && c >= 0 && r < n && c < n) {
                count += knightProbability_(n, k - 1, r, c, dp);
            }
        }
        return dp[k][row][column] = count*1.0/8.0 ;
    }
}
