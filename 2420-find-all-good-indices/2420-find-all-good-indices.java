class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[]left=new int[nums.length];
        int[]right=new int[nums.length];
        Arrays.fill(left,1);
         Arrays.fill(right,1);
        ArrayList<Integer>a=new ArrayList<>();
        //if(nums.length==2)return a;
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>=nums[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
            
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>=nums[i]){
              right[i]=right[i+1]+1; 
            }else{
              right[i]=1; 
            }
            
        }
        int count=0;
        for(int i=k;i<nums.length-k;i++){
            if(left[i-1]>=k && right[i+1]>=k){
                a.add(i);
            }
        }
        
        return a;
        
    }
}