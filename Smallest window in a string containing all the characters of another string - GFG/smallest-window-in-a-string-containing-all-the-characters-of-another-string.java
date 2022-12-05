//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String t)
    {
       int ns = s.length(), nt = t.length(), si = 0, ei = 0, count = nt, len = (int) 1e9;
        String ans = "";
        int[] freq = new int[128];
        for (int i = 0; i < nt; i++) {
            freq[t.charAt(i)]++;
        }
        while (ei < ns) {
            if (freq[s.charAt(ei)] > 0) count--;
            freq[s.charAt(ei)]--;
            ei++;

            while(count == 0) {
                if (len > ei - si) {
                    ans=s.substring(si,ei);
                    len = ei - si;
                }
                //mtlb ecess me nhi hai is lia count increase kia
                
                if(freq[s.charAt(si)]==0)count++;
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return len == (int) 1e9 ? "-1" : ans;
    }
}