class Solution {

    public int minDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return minDistance_memo(s, t, s.length(), t.length(), dp);
    }

    public static int minDistance_memo(String s1, String s2, int N, int M, int[][] dp) {
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (n == 0 || m == 0) {
                    dp[n][m] = n != 0 ? n : m;
                    continue;
                }

                if (s1.charAt(n - 1) == s2.charAt(m - 1))  dp[n][m] = dp[n - 1][m - 1]; else  dp[n][m] = Math.min(dp[n - 1][m], dp[n][m - 1]) + 1;
            }
        }
        return dp[N][M];
    }
}
