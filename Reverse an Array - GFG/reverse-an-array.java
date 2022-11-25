/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
		    int n=scn.nextInt();
		    int[]arr=new int[n];
		    for(int i=0;i<arr.length;i++){
		        arr[i]=scn.nextInt();
		    }
		    revrse(arr);
		     for(int i=0;i<arr.length;i++){
		  System.out.print(arr[i]+" ");
		}
		 System.out.println();
		   
		}
	
	}
	public static void revrse (int []arr) {
		//code
	  int l=0,h=arr.length-1;
	  while(l<=h){
	      int temp=arr[l];
	      arr[l]=arr[h];
	      arr[h]=temp;
	      l++;
	      h--;
	  }
	  
	}
}