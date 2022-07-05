class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean>s=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            s.put(nums[i],true);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(s.containsKey(nums[i]-1))
               {
                   s.put(nums[i],false);
               }
        }
        int ans=1;
        int max=0;
        int k=1;
         for(int i=0;i<nums.length;i++)
               {
                   while(s.get(nums[i]) && s.containsKey(nums[i]+k))
                   {
                       ++ans;
                        ++k;
                   }
                   if(max<ans)
                   {
                       max=ans;
                   }
                  k=1;
                 ans=1;
               }
               return max;
    }
}