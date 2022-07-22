class Solution {
    public int[] sortArrayByParity(int[] nums) {
         int i = 0;
        int j = 0;
        int[] copy = nums.clone();
        int n = nums.length;
        
        while(i < n){
            if(nums[i] % 2 == 1){
                i++;
            }else{
                swap(nums,i,j);
                i++;
                j++;
            }
        }
        i = 0;
        for(;i<n; i++){
            if(copy[i] % 2 != 0){
                nums[j++] = copy[i];
            }
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}