class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        
        long[]dp = new long[s.length() + 1];  //dp ka size string se ek bada banega bhai
        dp[0] = 1;
    
        
        HashMap<Character, Integer> lo = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++){
            dp[i] = (2  * dp[i - 1])%1000000007;
            
            char ch = s.charAt(i - 1);
            
            if(lo.containsKey(ch) == true){
                int j = lo.get(ch);       //last occurence is character ka is index par tha
                dp[i] = (dp[i] - dp[j - 1]) % MOD;
                
            }
            
            lo.put(ch, i);
    
            
        }
        if(dp[s.length()] < 0){
            dp[s.length()] += 1000000007;
        }
        
        return (int)(dp[s.length()]-1)%1000000007;
    }
}