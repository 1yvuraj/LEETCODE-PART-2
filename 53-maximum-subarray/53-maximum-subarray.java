class Solution {

    public int maxSubArray(int[] nums) {
       int gsum=0,cursum=0;
        for(int i=0;i<nums.length;i++){
            cursum+=nums[i];
            if(cursum>gsum)gsum=cursum;
            if(cursum<=0){
                cursum=0;
            }
        }
        if(gsum==0){
            Arrays.sort(nums);
        }
        return gsum==0?nums[nums.length-1]:gsum;
    }
}
