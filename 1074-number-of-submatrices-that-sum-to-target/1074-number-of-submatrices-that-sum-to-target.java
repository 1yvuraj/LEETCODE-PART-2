class Solution {
    public int numSubmatrixSumTarget(int[][] M, int target) {
        int max = -(int) 1e9;
        int[] cursum = new int[M[0].length];
        int sum1 = 0;
        int sum = 0;
        for (int i = 0; i < M.length; i++) {
            Arrays.fill(cursum, 0);
            for (int j = i; j < M.length; j++) {
                for (int k = 0; k < M[0].length; k++) cursum[k] += M[j][k];
                sum1 += subarraySum(cursum, target);
            }
        }
        
        return sum1;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return ans;
    }
}
