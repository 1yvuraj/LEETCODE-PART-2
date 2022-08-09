class Solution {
    public int longestIdealString(String s, int k) {
       int[]dp=new int[26];
        int ans=0;
       for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           int max=0;
           for(int j=Math.max(0,ch-'a'-k);j<=Math.min(25,ch-'a'+k);j++){
               max=Math.max(max,dp[j]);
           }
           dp[ch-'a']=max+1;
           ans=Math.max(ans,dp[ch-'a']);
       }
        return ans;

    }
}



