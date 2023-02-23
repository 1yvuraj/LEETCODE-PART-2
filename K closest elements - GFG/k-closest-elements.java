//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    class pair implements Comparable<pair>{
        int val;
        int diff;
        pair(int val,int diff){
            this.val=val;
            this.diff=diff;
        }
        public int compareTo(pair o){
            if(o.diff==this.diff)return o.val-this.val;

           else return this.diff-o.diff;
        }
    }
    int[] printKClosest(int[] nums, int n, int k, int x) {
       PriorityQueue<pair> pq = new PriorityQueue<pair>();
       int[]ans=new int[k];
     
        for(int i=0;i<n;i++){
               if(nums[i]==x)continue;
               pq.add(new pair(nums[i],Math.abs(x-nums[i])));
        }
       
        
        int i=0;
        int idx=0;
        while(i<k){
            ans[i]=pq.poll().val;
            i++;
            
        }
        return ans;
        
    }
}
