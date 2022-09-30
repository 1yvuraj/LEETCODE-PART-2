class Solution {
    public int combinationSum4(int[] coins, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return coinChangeCombination_IN(coins, target, "", dp);
    }

    public static int coinChangeCombination_IN(int[] coins, int tar, String psf, int[] dp) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }
        if (dp[tar] != -1) return dp[tar];
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += coinChangeCombination_IN(coins, tar - coins[i], psf + coins[i] + " ", dp);
            }
        }
        return dp[tar] = count;
    }
}
