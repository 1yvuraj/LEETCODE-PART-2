class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>map=new HashSet<>();
        Boolean[]dp=new Boolean[s.length()+1];
        for(String val:wordDict){
            map.add(val);
        }
        return help(s,map,0,dp);
    }
    public boolean help(String s,HashSet<String>map,int si,Boolean[]dp) {
      if(si==s.length())return true;
      if(dp[si]!=null)return dp[si];
      for(int i=si;i<=s.length();i++){
         if(map.contains(s.substring(si,i))){
             if(help(s,map,i,dp))return dp[i]=true;
         }
      }
        return dp[si]=false;
    }
}