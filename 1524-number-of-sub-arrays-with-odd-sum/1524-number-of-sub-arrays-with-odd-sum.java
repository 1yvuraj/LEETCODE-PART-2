class Solution {
    public int numOfSubarrays(int[] presum) {
        int even = 0;
        int odd = 0;
        int sum = 0;
        long count = 0;
        for (int i = 0; i < presum.length; i++) {
            sum += presum[i];
            if (sum % 2 == 0) {
                count+= odd;
                even++;
            } else {
                count+= even+1;
                odd++;
            }
        }
        return (int)(count%1000000007);
    }
}
