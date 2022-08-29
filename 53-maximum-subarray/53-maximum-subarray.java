class Solution {

    public int maxSubArray(int[] nums) {
        int gsum = -(int)1e9, cursum = 0, gs = 0, ge = 0, cs = 0;
        for (int i = 0; i < nums.length; i++) {
            cursum += nums[i];
            if (cursum > gsum) {
                gsum = cursum;
                gs = cs;
                ge = i;
            }
            if (cursum <= 0) {
                cursum = 0;
                cs = i + 1;
            }
        }
       
        return gsum ;
    }
}
