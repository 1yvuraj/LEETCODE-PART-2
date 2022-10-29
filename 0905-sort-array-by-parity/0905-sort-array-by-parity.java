class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // int si=0,ei=0;
        // while(ei<nums.length){
        //     while(ei<nums.length && nums[ei]%2!=0){
        //         ei++;
        //     }
        //     swap(si,ei,nums);
        //     si++;
        //     ei++;
        // }
        // return nums;
        int si=0,ei=0;
        while(ei<nums.length){
            if(nums[ei]%2==0){
                swap(si,ei,nums);
                si++;
                ei++;
            }else{
                ei++;
            }
        }
        return nums;
        
    }
    public static void swap(int si,int ei,int[] nums) {
        if(ei<nums.length){
        int temp=nums[si];
        nums[si]=nums[ei];
        nums[ei]=temp;
        }
    }
}