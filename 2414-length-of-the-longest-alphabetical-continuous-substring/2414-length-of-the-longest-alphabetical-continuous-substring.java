class Solution {
    public int longestContinuousSubstring(String s) {
       int[]arr=new int[26];
       if(s.length()==1)return 1;
       int si=1,prev=s.charAt(0);
        int len=1,ans=1;
       while(si<s.length()){
           if(s.charAt(si)-prev==1){
               len++;
               ans=Math.max(ans,len);
           }else{
               len=1;
           }
           prev=s.charAt(si);
           si++;
       }
        return ans;
        
    }
}