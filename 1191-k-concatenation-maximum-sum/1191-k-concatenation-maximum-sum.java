class Solution {

    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]% ((int) 1e9 + 7);
        }
        if (k == 1) {
            return k(arr, k)% ((int) 1e9 + 7);
        } else if (sum < 0) {
            return ks(arr, k)% ((int) 1e9 + 7);
        } else {
            return (int)(ks(arr, k)% ((int) 1e9 + 7) + ((k - 2) * sum)% ((int) 1e9 + 7));
        }
    }

    public int k(int[] arr, int k) {
        long gsum = 0, cursum = 0;
        for (int i = 0; i < arr.length; i++) {
            cursum += arr[i]% ((int) 1e9 + 7);
            if (cursum > gsum) gsum = cursum% ((int) 1e9 + 7);
            if (cursum <= 0) {
                cursum = 0;
            }
        }
        return (int)(gsum % ((int) 1e9 + 7));
    }

    public int ks(int[] arr, int k) {
        int[] ans = new int[arr.length * 2];
        int y = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[y] = arr[i % arr.length];
            y++;
        }
        return k(ans, k)% ((int) 1e9 + 7);
    }
}
