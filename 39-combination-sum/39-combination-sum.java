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

    public void findcombinations(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //pick up
        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            findcombinations(idx, arr, target - arr[idx], ans, ds);
            ds.remove(ds.size() - 1);
        }

        //not pick up
        findcombinations(idx + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
