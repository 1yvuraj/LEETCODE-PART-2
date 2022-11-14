class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        Arrays.sort(nums);
        int i=0,r=nums.length-1;
        while(i<r){
            set.add(nums[i]+nums[r]);
            i++;
            r--;
        }
        return set.size();
    }
}