class Solution {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = getMax(nums, firstLen, secondLen);
        int max2 = getMax(nums, secondLen, firstLen);
        return Math.max(max1, max2);
    }

    public int getMax(int[] nums, int firstLen, int secondLen) {
        int[] arr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == firstLen - 1) {
                arr[i] = sum;
            } else if (i >= firstLen) {
                sum -= nums[i - firstLen];
                arr[i] = Math.max(sum, arr[i - 1]);
            }
        }
        int[] right = new int[nums.length];
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (i == nums.length - secondLen) {
                right[i] = sum;
            } else if (i < nums.length - secondLen) {
                sum -= nums[i + secondLen];
                right[i] = Math.max(sum, right[i + 1]);
            }
        }
        sum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            sum = Math.max(sum, arr[i] + right[i + 1]);
        }
        return sum;
    }
}
