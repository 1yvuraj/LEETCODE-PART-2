//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
    int countPairs(int num1[][], int num2[][], int n, int k) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = 0;
		for(int i = 0 ; i < num1.length ;i++) {
			for(int j = 0; j < num1[0].length ;j++) {
				map.put(num1[i][j], map.getOrDefault(num1[i][j], 0) + 1);
			}
		}
		
		for(int i = 0 ;i < num2.length ;i++) {
			for(int j = 0 ;j < num2[0].length ;j++) {
				if(map.containsKey(k - num2[i][j])) {
					ans += map.get(k - num2[i][j]);
					map.remove(k - num2[i][j]);
				}
			}
		}
		return ans;
    }
}