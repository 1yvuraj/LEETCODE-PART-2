class Solution {

    public int[] cycleLengthQueries(int k, int[][] queries) {
        int[] ans = new int[ queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int m = queries[i][1];
            int count1 = 0;
            int count2 = 0;
            while (n != m) {
                if (n > m) {
                    n = n / 2;
                    count1++;
                } else {
                    m = m / 2;
                    count2++;
                }
            }
            ans[i] = count1+count2 + 1;
        }
        return ans;
    }
}
