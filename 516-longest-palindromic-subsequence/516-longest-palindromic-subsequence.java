class Solution {
    public int longestPalindromeSubseq(String S) {
        int[][] dp = new int[S.length()][S.length()];
        return help(S, 0, S.length() - 1, dp);
    }
    public int help(String s, int I, int J, int[][] dp) {
        for (int gap = 0; gap < s.length(); gap++) {
            for (int i = 0, j = gap; j < s.length(); i++, j++) {
                if (i >= j) {
                    dp[i][j] = i == j ? 1 : 0;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[I][J];
    }
}
