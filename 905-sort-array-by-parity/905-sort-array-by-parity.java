class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        int[] copy = nums.clone();
        while(i < nums.length) {
            if(nums[i] % 2 == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        
        
       
        for(int k=0;k<copy.length;k++){
            if(copy[k]%2!=0){
                nums[j++]=copy[k];
            }
        }
        return nums;
    }
    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
