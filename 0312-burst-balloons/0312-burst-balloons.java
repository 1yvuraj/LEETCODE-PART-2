class Solution {
    public int maxCoins(int[] nums) {
        int[][]dp=new int[nums.length+1][nums.length+1];
        return help(nums,0,nums.length-1,dp);
    }
    public int help(int[] nums,int si,int ei,int[][]dp) {
        if(dp[si][ei]!=0)return dp[si][ei];
        int leftlimit=si==0?1:nums[si-1];
        int rightlimit=ei==nums.length-1?1:nums[ei+1];
        int max=-(int)1e9;
        for(int cut=si;cut<=ei;cut++){
            int left=cut==si?0:help(nums,si,cut-1,dp);
            int right=cut==ei?0:help(nums,cut+1,ei,dp);
            
            max=Math.max(max,left+right+leftlimit*rightlimit*nums[cut]);
        }
        return dp[si][ei]=max;
    }
}