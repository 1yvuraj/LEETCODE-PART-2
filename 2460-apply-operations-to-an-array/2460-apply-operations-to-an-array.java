class Solution {
    public int[] applyOperations(int[] nums) {
        int[]arr=new int[nums.length];
        int check=nums[0];
        for(int i=1;i<nums.length;i++){
            if(check==nums[i]){
                nums[i-1]*=2;
                nums[i]=0;
            }
            check=nums[i];
        }
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                arr[idx]=nums[i];
                idx++;
            }
        }
        return arr;
    }
}