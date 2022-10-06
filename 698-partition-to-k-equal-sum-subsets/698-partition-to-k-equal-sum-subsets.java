class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int val : nums) {
            sum += val;
            max = Math.max(max, val);
        }
        boolean[] vis = new boolean[nums.length];
        if (sum % k == 1 || max > sum / k) return false;
        return check(nums, 0, 0, sum / k, k, vis);
    }

    public boolean check(int[] nums, int idx, int sumsf, int tar, int k, boolean[] v) {
        if (k == 0) return true;
        if (sumsf > tar) return false;
        if (tar == sumsf) {
            return check(nums, 0, 0, tar, k - 1, v);
        }
        boolean res = false;
        for (int i = idx; i < nums.length; i++) {
            if (tar - nums[i] >= 0 && nums[i]>-1) {
                int val = nums[i];
                nums[i]=-1;
                res = res || check(nums, i + 1, sumsf + val, tar, k, v);
                nums[i]=val;
            }
        }
        return res;
    }
}
