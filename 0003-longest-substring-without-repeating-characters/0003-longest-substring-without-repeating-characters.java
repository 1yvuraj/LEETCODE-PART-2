class Solution {

    public int lengthOfLongestSubstring(String s) {
        int si = 0, ei = 0;
        int[] arr = new int[128];
        int count = 0, len = 0;
        while (ei < s.length()) {
            if (arr[s.charAt(ei)] == 1) {
                count++;
            }
            arr[s.charAt(ei)]++;
            ei++;
            while (count > 0) {
                if (arr[s.charAt(si)] == 2) {
                    
                    count--;
                }
                arr[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }
}
