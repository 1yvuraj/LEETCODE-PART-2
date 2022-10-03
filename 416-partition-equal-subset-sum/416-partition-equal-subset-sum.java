class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int val:nums)sum+=val;
        if(sum%2!=0)return false;
        int tar=sum/2;
        Boolean[][]dp=new Boolean[tar+1][nums.length+1];
        return coinChangeCombination_Sin(nums,tar,nums.length,dp);
    }
    public  boolean coinChangeCombination_Sin(int[] coins, int tar, int idx, Boolean[][]dp) {
    if (idx==0 || tar == 0) {
       
        return tar==0?true:false;
    }
    if(tar<0)return false;
    if(dp[tar][idx]!=null)return dp[tar][idx];
    boolean count = false;
   
        if (tar - coins[idx -1] >= 0) {
            count = count || coinChangeCombination_Sin(coins, tar - coins[idx-1], idx-1,dp);
        }
         count = count || coinChangeCombination_Sin(coins, tar, idx -1,dp);
    
    return dp[tar][idx]=count;
}
}