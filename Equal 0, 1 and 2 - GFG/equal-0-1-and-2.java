//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        HashMap<String,Integer>map=new HashMap<>();
        int c0=0;
        int c1=0;
        int c2=0;
        String ans=(c1-c0)+"#"+(c2-c1);
        long main=0;
        map.put(ans,1);
        for(int i=0;i<str.length();i++){
            int ch=str.charAt(i)-'0';
            if(ch==0){
                c0++;
            }else if(ch==1){
                c1++;
            }else{
                c2++;
            }
            String a=(c1-c0)+"#"+(c2-c1);
            if(map.containsKey(a)){
                main+=map.get(a);
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
        return main;
    }
} 