class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return help(nums,goal)-(goal!=0?help(nums,goal-1):0);
    }
     public int help(int[] nums, int goal) {
        int si = 0, ei = 0, count = 0, len = 0;
        // vector<int> freq(128,0);

        while (ei < nums.length) {
            count += nums[ei];

            ei++;
            //kuki do distint hone chia
            while (count > goal) {
                //matlb 2 distint character bache hai to count decres
                
                if (nums[si] == 1) {
                    count-=nums[si] ;
                }

                si++;
            }
            len += ei - si;
            
           
        }
        return len;
    }
    
}
