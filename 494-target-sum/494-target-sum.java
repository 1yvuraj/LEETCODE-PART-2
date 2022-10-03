class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ok(nums,target,nums.length);
    }
    public static int ok(int[]nums,int tar,int idx)
    {
       
        
        if(idx==0)
        {
            return tar==0?1:0;
        }
        
        int count=0;
        count+=ok(nums,tar-nums[idx-1],idx-1);
        count+=ok(nums,tar+nums[idx-1],idx-1);
        return count;
        
    }
}