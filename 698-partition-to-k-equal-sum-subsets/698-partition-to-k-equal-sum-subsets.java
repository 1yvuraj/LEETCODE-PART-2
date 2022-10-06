class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int val : nums) {
            sum += val;
            max = Math.max(max, val);
        }
        if (sum % k != 0 || max > sum / k) return false;
        return check(nums, 0, 0, sum / k, k);
    }

    public boolean check(int[] nums, int idx, int sumsf, int tar, int k) {
        if (k == 0) return true;
        if (sumsf > tar) return false;
        if (tar == sumsf) {
            return check(nums, 0, 0, tar, k - 1);
        }
        boolean res = false;
        for (int i = idx; i < nums.length; i++) {
            if(nums[i]==-1)continue;
          
                int val = nums[i];
                nums[i] = -1;
                res = res || check(nums, i + 1, sumsf + val, tar, k);
                nums[i] = val;
            
        }
        return res;
    }
}
