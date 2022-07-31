class Solution {
    public int maximumGroups(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length;
        int i=0;
        int ans=0;
        while(size>=++i){
            size-=i;
            ans++;
        }
        return ans;
    }
}