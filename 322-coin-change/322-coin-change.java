class Solution {
    public int coinChange(int[] coins, int target) {
        int[]dp = new int[target + 1];
        Arrays.fill(dp, -1);
        int ans=coinChangeCombination_IN(coins, target, "", dp);
        return ans==1000000001?-1:ans;
    }
    public static int coinChangeCombination_IN(int[] coins, int tar, String psf,int[]dp) {
        if (tar == 0) {
            System.out.println(psf);
            return 0;
        }
        if(dp[tar]!=-1)return dp[tar];
        int count = (int)1e9;
        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count = Math.min(count,coinChangeCombination_IN(coins, tar - coins[i], psf + coins[i] + " ",dp));
            }
        }
        return dp[tar]=count+1;
    }
}
