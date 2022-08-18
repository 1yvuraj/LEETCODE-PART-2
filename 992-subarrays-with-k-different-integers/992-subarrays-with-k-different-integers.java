class Solution {

    public int help(int[] s, int k) {
        int n = s.length, si = 0, ei = 0, count = 0, len = 0;
        int[] freq = new int[s.length+1]; // vector<int> freq(128,0);

        while (ei < n) {
            //kuki distict character dekhne hai to zero kia hai
            if (freq[s[ei]] == 0) {
                count++;
            }
            //len++;
            freq[s[ei]]++;
            ei++;
            //kuki do distint hone chia
            while (count > k) {
                //matlb 2 distint character bache hai to count decrese
                
                if (freq[s[si]] == 1) {
                    count--;
                }
                freq[s[si]]--;
                si++;
            }
            len+=ei-si;
        }
        return len;
    }
    public int subarraysWithKDistinct(int[] s, int k) {
        return help(s,k)-help(s,k-1);
    }
}
