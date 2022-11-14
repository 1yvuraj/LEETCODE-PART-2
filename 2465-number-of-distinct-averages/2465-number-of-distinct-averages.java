class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Double>set=new HashSet<>();
        Arrays.sort(nums);
        int i=0,r=nums.length-1;
        while(i<r){
            Double sum=(nums[i]+nums[r])/2.0;
            set.add(sum);
            i++;
            r--;
        }
        return set.size();
    }
}