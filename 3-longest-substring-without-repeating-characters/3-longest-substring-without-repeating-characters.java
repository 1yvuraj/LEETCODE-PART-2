class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int n = s.length(), si = 0, ei = 0, count = 0, len = 0;
        int[] freq = new int[128]; // vector<int> freq(128,0);

        while (ei < n) {
            if (freq[s.charAt(ei)] == 1) {
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;

            while (count > 0) {
                if (freq[s.charAt(si)] == 2) {
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }

            len = Math.max(len, ei - si);
        }
        return len;
    }
}
