class Solution {
    public int maxProfit(int[] prices) {
       return  Profit(prices);
    }
     public int Profit(int [] price)
     {   int min=9999999;
         int max=-1;
         int []dp=new int [ price.length] ;  
        int []dp2=new int [ price.length]  ; 
        for(int i=0;i<dp.length;i++)
        {
            min=Math.min(min,price[i]);
            dp[i]=min;
            dp2[i]=price[i]-dp[i];
            max=Math.max(max,dp2[i]);
            
        }
       
        return max;
        
     }
}