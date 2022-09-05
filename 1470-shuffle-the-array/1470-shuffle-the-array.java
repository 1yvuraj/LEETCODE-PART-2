class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[]ans=new int[nums.length];
        int y=0;
        int u=nums.length/2;
        for(int i=0;i<nums.length;i+=2){
            ans[i]=nums[y];
            y++;
            
        }
        for(int i=1;i<nums.length;i+=2){
            ans[i]=nums[u];
            u++;
            
        }
        return ans;
    }
}