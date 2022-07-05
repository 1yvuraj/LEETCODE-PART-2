// { Driver Code Starts
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
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public class pair implements Comparable<pair>{
        int val;
        int idx;
        pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        public int compareTo(pair o){
            return this.val-o.val;
        }
    }
    public int minSwaps(int nums[])
    {
       pair[]arr=new pair[nums.length]; 
       for(int i=0;i<nums.length;i++)
       {
           arr[i]=new pair(nums[i],i);
       }
       Arrays.sort(arr);
       boolean[] visit=new boolean[nums.length];
       int ans=0;
       for(int i=0;i<nums.length;i++){
           if(visit[i]==true||arr[i].idx==i){
               continue;
           }
           int j=i;
           int len=0;
          
           while(visit[j]==false){
               visit[j]=true;
               j=arr[j].idx;
               len++;
           }
           ans+=len-1;
       }
       return ans;
    }
}