//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String matrixChainOrder(int arr[],int n)
    {
        // code here
        int[][]dp=new int[arr.length+1][arr.length+1];
        String[][]sdp=new String[arr.length+1][arr.length+1];
        int ans=help(arr,0,arr.length-1,dp,sdp);
        return sdp[0][arr.length-1];
    }
    static int help(int arr[],int si,int ei,int[][]dp,String[][]sdp)
    {
         if(ei-si==1){
             sdp[si][ei]=(char)(si+'A')+"";
             return dp[si][ei]=0;
         }
         if(dp[si][ei]!=0)return dp[si][ei];
         int ans=(int)1e9;
         String a="";
         for(int cut=si+1;cut<ei;cut++){
             int left=help(arr,si,cut,dp,sdp);
             int right=help(arr,cut,ei,dp,sdp);
             if(left+arr[si]*arr[ei]*arr[cut]+right<ans){
             ans=left+arr[si]*arr[ei]*arr[cut]+right;
             a= "("+sdp[si][cut]+sdp[cut][ei]+")";
             }
         }
         sdp[si][ei]=a;
         return dp[si][ei]=ans;
    }
}