class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int val:nums)sum+=val;
        if(sum%2!=0)return false;
        int tar=sum/2;
        Boolean[][]dp=new Boolean[tar+1][nums.length+1];
        return coinChangeCombination_Sin(nums,tar,0,dp);
    }
    public  boolean coinChangeCombination_Sin(int[] coins, int tar, int idx, Boolean[][]dp) {
    if (tar == 0) {
       
        return true;
    }
    if(dp[tar][idx]!=null)return dp[tar][idx];
    boolean count = false;
    for (int i = idx; i < coins.length; i++) {
        if (tar - coins[i] >= 0) {
            count = count || coinChangeCombination_Sin(coins, tar - coins[i], i + 1,dp);
        }
    }
    return dp[tar][idx]=count;
}
}