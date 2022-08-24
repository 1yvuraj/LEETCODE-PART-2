class Solution {
    public int subarraysDivByK(int[] n, int k) {
        int[]nums=new int[30000];
        nums[0]++;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (nums[rem]>0) {
                ans += nums[rem];
                nums[rem]++;
            } else {
               nums[rem]=1;
            }
        }
        return ans;
    }
}
