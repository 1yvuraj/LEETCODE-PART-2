class Solution {

    public int longestOnes(int[] s, int k) {
        int n = s.length, si = 0, ei = 0, count = 0, len = 0;
        while (ei < n) {
            //kuki distict character dekhne hai to zero kia hai
            if (s[ei] == 0) {
                count++;
            }
            ei++;
            //kuki do distint hone chia
            while (count > k) {
                //matlb 2 distint character bache hai to count decrese

                if (s[si] == 0) {
                    count--;
                }
                si++;
                
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }
}
