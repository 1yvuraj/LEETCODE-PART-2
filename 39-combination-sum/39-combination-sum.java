// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>>ans=new ArrayList<>();
//         ArrayList<Integer>a=new ArrayList<>();
//         coinChangeCombination_IN(candidates,target,0,ans,a);
//         return ans;
//     }
//     public  int coinChangeCombination_IN(int[] coins, int tar, int idx, List<List<Integer>>ans,ArrayList<Integer>a) {
//         if (tar == 0) {
//             List<Integer> base = new ArrayList<>(a);
//             ans.add(base);
//             return 1;
//         }

//         int count = 0;
//         for (int i = idx; i < coins.length; i++) {
//             if (tar - coins[i] >= 0) {
//                 a.add(coins[i]);
//                 count += coinChangeCombination_IN(coins, tar - coins[i], i, ans,a);
//                 a.remove(a.size()-1);
//             }
//         }
    
//         return count;
//     }

// }
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        
        combinationSum( nums, target, 0, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    public void combinationSum( int[] nums, int target, int idx,List<List<Integer>> res, List<Integer> temp, int ssf){
        if( ssf == target ){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            if(ssf+nums[i]<=target){
            temp.add(nums[i]);
            combinationSum( nums, target,i, res, temp,ssf+nums[i]);
            temp.remove(temp.size()-1);
            
            }
        }
    }
}