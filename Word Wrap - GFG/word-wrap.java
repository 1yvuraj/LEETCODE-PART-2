//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int[][] dp = new int[nums.length+1][3101];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return help(nums,k,0,k,dp);
    }
     public int help (int[] nums, int k,int i,int rem,int[][]dp)
    {
        if(i==nums.length)return 0;
        if(dp[i][rem+1000]!=-1)return dp[i][rem+1000];
        int ans=0;
        if(nums[i]>rem){
            //ye line ki matlb next line me dalna hai word 
           ans=(rem+1)*(rem+1)+help(nums,k,i+1,k-nums[i]-1,dp);
        }else {
            //ye line ki matlb next line me dalna hai word 
            int option1=0;
            int option2=0;
            option1=(rem+1)*(rem+1)+help(nums,k,i+1,k-nums[i]-1,dp);
            //ye line ki matlb same  line me dalna hai word 
            option2=help(nums,k,i+1,rem-nums[i]-1,dp);
            ans=Math.min(option1,option2);
        }
        return dp[i][rem+1000]=ans;
    }
}