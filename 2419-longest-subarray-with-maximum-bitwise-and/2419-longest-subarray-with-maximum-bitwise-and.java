class Solution {

    public int longestSubarray(int[] nums) {
        int ans = -(int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
        }
        int l = 0;
        int max=-(int)1e9;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i]==ans){
                l++;;
            }else { 
                l=0;
            }
            max=Math.max(max,l);
        }
        return max;
    }
}
