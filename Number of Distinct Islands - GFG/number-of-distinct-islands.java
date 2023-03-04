//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String ans="";
    int countDistinctIslands(int[][] grid) {
        HashSet<String>set=new HashSet<>();
         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]==1){
                 dfs(i,j,grid.length,grid[0].length,grid);
                 set.add(ans);
                 ans="";
                 }
             }
         }
         return set.size();
    }
    void dfs(int sr,int sc,int er,int ec,int[][] grid) {
        if(sr<0 || sc<0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]==0)return;
        grid[sr][sc]=0;
        ans+='R';
        dfs(sr,sc+1,er,ec,grid);
        ans+='D';
         dfs(sr+1,sc,er,ec,grid);
          ans+='L';
         dfs(sr,sc-1,er,ec,grid);
          ans+='U';
         dfs(sr-1,sc,er,ec,grid);
    }
}
