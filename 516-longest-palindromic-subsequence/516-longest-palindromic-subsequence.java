class Solution {
    public int longestPalindromeSubseq(String S) {
        int[][]dp=new int[S.length()][S.length()];
        for(int[]d:dp)Arrays.fill(d,-1);
        return help(S,0,S.length()-1,dp);
    }
    public int help(String s,int i,int j,int[][]dp) {
        if(i>=j)return i==j?1:0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=help(s,i+1,j-1,dp)+2;
        }else{
            return dp[i][j]=Math.max(help(s,i+1,j,dp),help(s,i,j-1,dp));
        }
        
    }
}