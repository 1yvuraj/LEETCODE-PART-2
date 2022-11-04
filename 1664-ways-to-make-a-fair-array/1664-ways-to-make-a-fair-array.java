class Solution {

    public int waysToMakeFair(int[] nums) {
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int oddsum = 0;
        int evensum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evensum += nums[i];
            } else {
                oddsum += nums[i];
            }
            odd[i] = oddsum;
            even[i] = evensum;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                int odds = even[nums.length - 1] - nums[0];
                int evens = odd[nums.length - 1];
                if (odds == evens) {
                    ans++;
                }
                continue;
            }
            int odds = odd[i - 1] + even[nums.length - 1] - even[i];
            int evens = even[i - 1] + odd[nums.length - 1] - odd[i];
            if (odds == evens) {
                ans++;
            }
        }
        return ans;
    }
}
