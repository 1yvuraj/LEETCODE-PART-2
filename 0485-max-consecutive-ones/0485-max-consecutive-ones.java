class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int si=0;
        int ei=0;
        int len=0;
        int max=0;
        while(ei<nums.length){
            if(nums[ei]==0){
              len++;
            }
            ei++;
            while(len==1){
                if(nums[si]==0){
                    len--;
                }
                    si++;
            }
             max=Math.max(max,ei-si);
            
           
        }
        return max;
    }
}