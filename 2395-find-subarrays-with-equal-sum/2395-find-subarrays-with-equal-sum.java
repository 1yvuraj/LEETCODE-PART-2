class Solution {
    public boolean findSubarrays(int[] nums) {
      HashSet<Integer>map=new HashSet<>();
        map.add(nums[0]+nums[1]);
        int sum=0;
        for(int i=1;i<nums.length-1;i++){
            sum+=nums[i]+nums[i+1];
            if(map.contains(sum))return true;
            map.add(sum);
            sum=0;
        }
        return false;
        
    }
}