class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, n = nums.length;
        for (int ele : nums)
            sum += ele;
        if (target > sum || target < -sum)
            return 0;

        int[][] dp = new int[2 * sum + 1][n+1];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return findTargetSumWays(nums,sum + target, n, sum,dp);
    }
    public  int findTargetSumWays(int[]nums,int tar,int idx,int sum,int[][]dp)
    {
        if(idx==0)
        {
            return tar==sum?1:0;
        }
        if(dp[tar][idx]!=-1)return dp[tar][idx];
        int count=0;
        if((tar-nums[idx-1])>=0)count+=findTargetSumWays(nums,tar-nums[idx-1],idx-1,sum,dp);
        if((tar+nums[idx-1])<=2*sum)count+=findTargetSumWays(nums,tar+nums[idx-1],idx-1,sum,dp);
        return dp[tar][idx]=count;
        
    }
}