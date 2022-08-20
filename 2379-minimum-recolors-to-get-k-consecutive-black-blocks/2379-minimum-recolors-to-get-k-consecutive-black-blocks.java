class Solution {

    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        while (blocks.length() - cnt >= k) {
            int count = 0;
            for (int j = cnt; j < k + cnt; j++) {
                if (blocks.charAt(j) == 'W') {
                    count++;
                }
            }
            min = Math.min(min, count);
            cnt++;
        }
        return min;
    }
}
