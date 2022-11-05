//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            int ans  = ob.singleDigit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int singleDigit(long n){
        // code here
       long sum=0;
        while(n>9){
         n=help(n,sum);
         sum=0;
        }
        return (int)n;
    }
    public static long help (long n,long sum) 
	{
        if(n==0){
           return sum;
        }
		long a=help(n/10,sum+n%10);
		return a;
	}
	
}