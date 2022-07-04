class Solution {
   ArrayList<List<Integer>>main=new ArrayList<>();
   public List<List<Integer>> subsets(int[] nums) {
        // INterview Perparation Princy
        main=new ArrayList<>();
        ArrayList<Integer>ans=new ArrayList<>();
         helperFunction(nums,0,main,ans);
       return main;
    }
    public void helperFunction(int[] nums,int i,ArrayList<List<Integer>>main, ArrayList<Integer>ans){
        
        if(i==nums.length){
            ArrayList<Integer>a=new ArrayList<>(ans);
            main.add(a);
            return;
        }
        ans.add(nums[i]);
        helperFunction(nums,i+1,main,ans);
        ans.remove(ans.size()-1);
        helperFunction(nums,i+1,main,ans);
        
    }
}