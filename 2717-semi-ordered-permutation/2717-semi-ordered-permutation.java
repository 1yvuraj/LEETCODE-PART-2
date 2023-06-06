class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int x=0;
        int y=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)break;
             x++;
        }
          for(int i=0;i<nums.length;i++){
            if(nums[i]==nums.length)break;
             y++;
        }
        System.out.println(x+" "+y);
        if(x<y)return x+(nums.length-y-1);
        return x+(nums.length-y-1)-1;
    }
}