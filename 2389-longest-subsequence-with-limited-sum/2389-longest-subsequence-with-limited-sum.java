class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[]ans=new int[queries.length];
        int y=0;
       for(int i=0;i<queries.length;i++){
           int sum=0 ,j=0;
           for( j=0;j<nums.length;j++){
               if(sum+nums[j]>queries[i]){
                    ans[i]=j;
                    break;
               }
               sum+=nums[j];
           }
           if(j==nums.length)ans[i]=j;
           
          
       }
        return ans;
    }
}