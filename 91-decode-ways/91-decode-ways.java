class Solution {
    public int numDecodings(String s) {
        int[]dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return help(s,0,dp);
    }
    public int help(String s,int idx,int[]dp) {
        if(idx==s.length())return dp[idx]=1;
        if(dp[idx]!=-1)return dp[idx];
        char ch=s.charAt(idx);
        int count=0;
        if(ch=='0')return 0;
        count+=help(s,idx+1,dp);
        if(idx<s.length()-1){
            char ch1=s.charAt(idx+1);
            int num=(ch-'0')*10+(ch1-'0');
            if(num<=26){
                count+=help(s,idx+2,dp);
            }
        }
        return dp[idx]=count;
    }
}