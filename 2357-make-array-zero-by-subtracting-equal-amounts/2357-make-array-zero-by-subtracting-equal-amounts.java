class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) arr[nums[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                ans++;
            }
        }
        return ans;
    }
}
