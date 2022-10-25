class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return most(nums,k)-most(nums,k-1);
    }
    public int most(int[] nums, int k) {
        int si=0,ei=0,count=0,len=0;
        int[]arr=new int[nums.length+1];
        while(ei<nums.length){
            if(arr[nums[ei]]==0)count++;
            arr[nums[ei]]++;
            ei++;
            while(count>k){
                if(arr[nums[si]]==1){
                    count--;
                }
                arr[nums[si]]--;
                si++;
                
            }
            len+=ei-si;
        }
        return len;
    }
}