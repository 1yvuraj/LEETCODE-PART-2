class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,j;
        int[] result = new int[2];
        for(i=0; i<nums.length; i++){
           int req = target - nums[i];
           
           for(j=i+1; j<nums.length; j++){
               if (nums[j]==req) { 
                   result[0] = i;
                   result[1]=j;
                   break;
               }
               
           }
        }
        return result;
    }
}