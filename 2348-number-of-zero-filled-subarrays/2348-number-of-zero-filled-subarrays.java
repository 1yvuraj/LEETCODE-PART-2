class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long l = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                l++;
                count +=  l ;
            } else {
                l = 0;
            }
        }
        return count;
    }
}