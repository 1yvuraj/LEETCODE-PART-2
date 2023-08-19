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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] arr)
    {
        int[][]dir={{0,1},{1,0},{-1,0},{0,-1}};
        int[][]ans=new int[arr.length][arr[0].length];
        LinkedList<Integer>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2)
                q.addLast(i*arr[0].length+j);
                else if(arr[i][j]==1)fresh++;
            }
        }
        if (fresh == 0) return 0;
        boolean[][]visit=new boolean[arr.length][arr[0].length];
        int d=0;
        while(q.size()>0){
            int size=q.size();
            
            while(size-->0){
                int rem=q.removeFirst();
                int x=rem/arr[0].length;
                int y=rem%arr[0].length;
                if(visit[x][y])continue;
                visit[x][y]=true;
              
                for(int[] v:dir){
                   int i=x+v[0];
                   int j=y+v[1];
                   if(i>=0 && j>=0 && i<arr.length && j<arr[0].length && arr[i][j]==1){
                   
                    arr[i][j]=2;
                   q.addLast(i*arr[0].length+j);
                    fresh--;
                      if(fresh==0)return d+1;
                   }
                }
               
              
            }
            d++;
        }
        return -1;
            
    }
}