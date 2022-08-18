class Solution {

    public String minWindow(String s, String t) {
        int ns = s.length(), nt = t.length(), si = 0, ei = 0, count = nt, len = (int) 1e9;
        int gsi=0;
        int gei=0;
        String ans = "";
        int[] freq = new int[128];
        for (int i = 0; i < nt; i++) {
            freq[t.charAt(i)]++;
        }
        while (ei < ns) {
            if (freq[s.charAt(ei)] > 0) count--;
            freq[s.charAt(ei)]--;
            ei++;

            while(count == 0) {
                if (len > ei - si) {
                    ans=s.substring(si,ei);
                    len = ei - si;
                }
                if(freq[s.charAt(si)]==0)count++;
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return len == (int) 1e9 ? "" : ans;
    }
}
