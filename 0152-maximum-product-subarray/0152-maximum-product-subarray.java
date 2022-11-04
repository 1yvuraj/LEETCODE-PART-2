class Solution {
    public int maxProduct(int[] nums) {
        int max=-(int)1e9;
        int ans=1;
        for(int i=0;i<nums.length;i++){
          ans*=nums[i];
          max=Math.max(max,ans);
          if(ans==0){
              ans=1;
          }
            
        }
        ans=1;
        for(int i=nums.length-1;i>=0;i--){
          ans*=nums[i];
          max=Math.max(max,ans);
          if(ans==0){
              ans=1;
          }
            
        }
        return max;
    }
}