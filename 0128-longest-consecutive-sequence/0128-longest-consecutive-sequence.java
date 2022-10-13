class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
        }
        int k=1;
        int ans=1;
        int max=0;
        for(int i=0;i<nums.length;i++){
            while(map.get(nums[i]) && map.containsKey(nums[i]+k)){
                ans++;
                k++;
            }
            if(max<ans)max=ans;
            ans=1;
            k=1;
            
        }
        return max;
    }
}