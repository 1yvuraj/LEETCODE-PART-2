class Solution {

    public boolean isMatch(String s, String p) {
        p = Match(p);
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return help(s, p, s.length(), p.length(), dp);
    }

    public boolean help(String s, String p, int n, int m, Boolean[][] dp) {
        if (n == 0 || m == 0) {
            if (n == 0 && m == 0) return dp[n][m] = true; 
            else if (m == 1 && p.charAt(m - 1) == '*') return dp[n][m] = true; 
            else return dp[n][m] = false;
        }
        if (dp[n][m] != null) return dp[n][m];
        char ch1 = s.charAt(n - 1);
        char ch2 = p.charAt(m - 1);
        if (ch1 == ch2 || ch2 == '?') {
            return dp[n][m] = help(s, p, n - 1, m - 1, dp);
        } else if (ch2 == '*') {
            boolean res = false;
            res = res || help(s, p, n, m - 1, dp);
            res = res || help(s, p, n - 1, m, dp);
            return dp[n][m] = res;
        } else {
            return dp[n][m] = false;
        }
    }

    public String Match(String s) {
        if (s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == '*' && s.charAt(i - 1) == '*') {
                i++;
            }
            if (i < s.length()) sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
