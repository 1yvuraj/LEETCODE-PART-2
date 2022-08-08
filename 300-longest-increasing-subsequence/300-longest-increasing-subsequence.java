class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]dp=new int[nums.length];
        int maxs=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++) 
       {
           int max=0;
           for(int j=0;j<i;j++)
           {
               if(nums[i]>nums[j])
                max=Math.max(dp[j],max) ;
           }
           
           dp[i]=max+1;
           maxs=Math.max(dp[i],maxs);
           
       }
        return  maxs;
        
    }
}