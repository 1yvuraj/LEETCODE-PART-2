class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1)
        {
            return 1;
        }
        int p=nums[1]-nums[0];
        int count=p!=0?2:1;
        for(int i=2;i<nums.length;i++)
        {
            int cur=nums[i]-nums[i-1];
            if(p<=0&&cur>0||p>=0&&cur<0)
            {
                count+=1;
                p=cur;
            }
            
        }
        return count;
    }
}