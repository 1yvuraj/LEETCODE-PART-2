class Solution {
    public int longestOnes(int[] nums, int k) {
        int count=0,si=0,ei=0;
        int len=0;
        while(ei<nums.length){
            if(nums[ei]==0){
                count++;
            }
            ei++;
            while(count>k){
               
                if(nums[si]==0)count--;
                si++;
                
            }
             len=Math.max(len,ei-si);
        }
       
        return len;
    }
}