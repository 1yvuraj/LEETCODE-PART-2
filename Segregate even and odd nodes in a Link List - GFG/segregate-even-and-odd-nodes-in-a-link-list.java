//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends



class Solution{
    Node divide(int N, Node head){
       Node even=null;
       Node feven=null;
       Node odd=null;
        Node fodd=null;
       Node cur=head;
       while(cur!=null){
           if(cur.data%2==0){
               if(even==null){
                   even=cur;
                   feven=cur;
               }else{
                   even.next=cur;
                   even=even.next;
               }
           }else{
                if(odd==null){
                   odd=cur;
                   fodd=cur;
               }else{
                   odd.next=cur;
                   odd=odd.next;
               }
           }
           if(cur!=null)cur=cur.next;
       }
       if(feven!=null && fodd!=null)even.next=fodd;
       else return head;
       odd.next=null;
       return feven;
      
       
      
    }
}