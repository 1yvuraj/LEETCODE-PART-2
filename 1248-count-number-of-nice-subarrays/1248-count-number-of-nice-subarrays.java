class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        return help(nums, k) - help(nums, k - 1);
    }

    public int help(int[] nums, int k) {
        int n = nums.length, si = 0, ei = 0, count = 0, len = 0;
        while (ei < n) {
            //kuki distict character dekhne hai to zero kia hai
            if (nums[ei] % 2 == 1) {
                count++;
            }

            ei++;
            //kuki do distint hone chia
            while (count > k) {
                //matlb 2 distint character bache hai to count decrese

                if (nums[si] % 2 == 1) {
                    count--;
                }
                si++;
            }
            len += ei - si;
        }
        return len;
    }
}
