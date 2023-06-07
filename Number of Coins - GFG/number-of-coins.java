//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
	public int minCoins(int coins[], int M, int v) 
	{ 
	     int []dp=new int[v+1];
	     Arrays.fill(dp,-1);
	     int ans= help(coins,v,dp);
	     return ans==(int)1e9+1?-1:ans;
	     
	}
		public int help(int coins[], int tar,int[]dp) 
	{ 
	    if(tar==0){
	        
	        return 0;
	    }
	   
	    if(dp[tar]!=-1)return dp[tar];
	    int min=(int)1e9;
	    for(int i=0;i<coins.length;i++){
	        if(tar-coins[i]>=0)min=Math.min(min,help(coins,tar-coins[i],dp));
	    }
	    return dp[tar]=min+1;
	}
	
}