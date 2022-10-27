//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][]dp=new int[arr.length+1][arr.length+1];
        return help(arr,0,arr.length-1,dp);
    }
    static int help(int arr[],int SI,int EI,int[][]dp)
    {
        for(int gap=0;gap<arr.length;gap++){
            for(int  si=0,ei=gap;ei<arr.length;si++,ei++){
              if(ei-si==1){
                  dp[si][ei]=0;
                  continue;
              } 
             int ans=(int)1e9;
             for(int cut=si+1;cut<ei;cut++){
                 int left=dp[si][cut];
                 int right=dp[cut][ei];
                 ans=Math.min(ans,left+arr[ei]*arr[si]*arr[cut]+right);
             }
              dp[si][ei]=ans;
            }
        }
        return dp[SI][EI];
         
    }
}