class Solution {

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] ans = new int[nums.length];
        int idx = nums.length - 1;
        while (l <=r) {
            if (Math.abs(nums[l]) >=Math.abs(nums[r])) {
                ans[idx] = Math.abs(nums[l] * nums[l]);
                l++;
                idx--;
            } else {
                ans[idx] = Math.abs(nums[r] * nums[r]);
                r--;
                idx--;
            }
        }
        return ans;
    }
}
