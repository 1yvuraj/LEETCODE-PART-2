class Solution {
    public int findUnsortedSubarray(int[] nums) {
       int max=nums[0];
        int ei=-1;
        for(int i=1;i<nums.length;i++){
            if(max>nums[i]){
                ei=i;
                
            }else
            max=nums[i];
        }
         max=nums[nums.length-1];
        int si=0;
        for(int i=nums.length-2;i>=0;i--){
            if(max<nums[i]){
                si=i;
               
            }else
            max=nums[i];
        }
        return ei-si+1;
    }
}
// class Solution {
//     public int findUnsortedSubarray(int[] nums) {
//         int n = nums.length;
//         int end = -1, max = nums[0];
//         for (int i = 1; i < n; i++){
//             if (nums[i] < max)  
//                 end = i;
//             else    
//                 max = nums[i];
//         }
//         int start = 0, min = nums[n - 1];
//         for (int i = n - 2; i >= 0; i--){
//             if (nums[i] > min)  
//                 start = i;
//             else
//                 min = nums[i];
//         }
//         return end - start + 1;
//     }
// }