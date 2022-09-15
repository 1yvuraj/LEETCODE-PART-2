class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return help(text1,text2, text1.length(), text2.length(), dp);
    }
    public int help(String str1,String str2 ,int I, int J, int[][] dp) {
        for (int i = 0;i<=str1.length(); i++) {
            for (int j=0;j<=str2.length();j++) {
                if (i==0 || j==0) {
                    dp[i][j] =0;
                    continue;
                }
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[I][J];
    }
}
