// { Driver Code Starts
//Initial Template for Java

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
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isPossible(int[][] graph)
    {
         int count=0;
        int size=0;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(i!=j && graph[i][j]==1){
                    size++;
                }
            }
            if(size%2==1){
                count++;
                size=0;
            }
        }
        if(count==0){
            return 1;
        }
        return 0;
    }
}