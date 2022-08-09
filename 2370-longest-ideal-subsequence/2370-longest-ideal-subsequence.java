//class Solution {
    //public int longestIdealString(String s, int k) {
       // int[]dp=new int[26];
       //  int ans=0;
       // for(int i=0;i<s.length();i++){
       //     char ch=s.charAt(i);
       //     int max=0;
       //     for(int j=Math.max(0,ch-'a'-k);j<Math.min(26,ch-'a'+k);j++){
       //         max=Math.max(max,dp[j]);
       //     }
       //     dp[ch-'a']=max+1;
       //     ans=Math.max(ans,dp[ch-'a']);
       // }
       //  return ans;
//         public int longestIdealString(String s, int k) {
//         int n = s.length(), maxIdeal = 0;
//         int value[] = new int[26];
        
//         for(char ch: s.toCharArray()) {
//             int max = 0;
//             for(int i=Math.max(0, ch-'a'-k); i<Math.min(26, ch-'a'+k); i++)
//                 max = Math.max(max, value[i]);
//             value[ch-'a'] = max+1;
//             maxIdeal = Math.max(maxIdeal, value[ch-'a']);
//         }
        
//         return maxIdeal;
//     }

    //}
//}

// public int longestIdealString(String s, int k) {
//         int n = s.length(), maxIdeal = 0;
//         int value[] = new int[26];
        
//         for(char ch: s.toCharArray()) {
//             int max = 0;
//             for(int i=Math.max(0, ch-'a'-k); i<Math.min(26, ch-'a'+k); i++)
//                 max = Math.max(max, value[i]);
//             value[ch-'a'] = max+1;
//             maxIdeal = Math.max(maxIdeal, value[ch-'a']);
//         }
        
//         return maxIdeal;
//     }

class Solution {
    public int longestIdealString(String s, int k) {
        int n=s.length();
        int[] dp=new int[26];
        int res=0;
        
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int l=Math.max(0,c-'a'-k);
            int h=Math.min(25,c-'a'+k);
            
            int max=0;
            for(int j=l;j<=h;j++){
                max=Math.max(max,dp[j]);
            }
            res=Math.max(res,max+1);
            dp[c-'a']=max+1;
        }
        return res;
    }
}
