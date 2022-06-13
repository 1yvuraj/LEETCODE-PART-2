class Solution {

    public long countSubarrays(int[] nums, long k) {
        int i = 0;
        long res=0;
        long sum=0;
        for(int j=0;j<nums.length;j++)
        {
             sum+=nums[j];
            while(sum*(j-i+1)>=k)
            {
                sum-=nums[i++];
                
                
            }
            res+=j-i+1;
        }
        return res;
    }
}
