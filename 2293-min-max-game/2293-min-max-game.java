class Solution {
    public int minMaxGame(int[] nums) {
        int[] arr = new int[nums.length / 2];
        while (nums.length != 1) {
            for (int i = 0; i < nums.length / 2; i++) {
                if (i % 2 == 0) {
                    arr[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    arr[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = arr;
            arr = new int[nums.length / 2];
        }
        return nums[0];
    }
}
