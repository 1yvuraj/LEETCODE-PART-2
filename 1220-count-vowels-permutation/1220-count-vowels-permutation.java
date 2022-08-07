class Solution {
    public static int mod = (int)1e9+7;
    
    public int countVowelPermutation(int n) {
        int dp[][] = new int[n+1][6];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return solve(n,0,'c',dp)%mod;
    }
    
    public int solve(int n,int len,char lastChar,int dp[][]){
        if(len==n){
            return 1;
        }
        if(dp[len][charToIndex(lastChar)]!=-1){
            return dp[len][charToIndex(lastChar)]%mod;
        }
        int ans = 0;
        char next[] = nextChar(lastChar);
        for(int i=0;i<next.length;i++){
            ans= (ans+(solve(n,len+1,next[i],dp)%mod))%mod;
        }
     
        dp[len][charToIndex(lastChar)] = ans;
        return ans;
    }
    
    public char[] nextChar(char currChar){
        
       switch(currChar){
               case 'a':
               return new char[]{'e'};
               case 'e':
               return new char[]{'a','i'};
               case 'i':
               return new char[]{'a','e','o','u'};
               case 'o':
               return new char[]{'i','u'};
               case 'u':
               return new char[]{'a'};
           default:
               return new char[]{'a','e','i','o','u'};
       }
   }
    
    public int charToIndex(char currChar){
        
       switch(currChar){
               case 'a':
               return 1;
               case 'e':
               return 2;
               case 'i':
               return 3;
               case 'o':
               return 4;
               case 'u':
               return 5;
           default:
               return 0;
       }
   }
}