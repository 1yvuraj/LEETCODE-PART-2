//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int l = Integer.parseInt(element[1]);
		    int r = Integer.parseInt(element[2]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.countSubarrays(arr, n, l, r));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static long countSubarrays(int arr[], int n, int left, int right)  
    { 
        // Complete the function
        int si = 0, ei = 0, count = 0;
        long res = 0;
    while (ei < arr.length) {
      if ( arr[ei]>=left  && arr[ei] <= right) {
        count = ei - si + 1;
      } else if (arr[ei] < left) {
        count = count;
      } else if (arr[ei] > right) {
        si = ei + 1;
        count = 0;

      }
      res += count;
      ei++;
    }
    return res;
    } 
}

