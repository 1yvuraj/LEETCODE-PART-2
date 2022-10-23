class Solution {
    public String minWindow(String s, String t) {
        int si = 0, ei = 0, count = t.length(), len = (int)1e9;
        String ans="";
        int[] freq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        while (ei < s.length()) {
            if (freq[s.charAt(ei)] > 0) 
                count--;
                freq[s.charAt(ei)]--;
            
            ei++;
            while(count == 0) {
                
                if(len>ei-si){
                    len=ei-si;
                    ans=s.substring(si,ei);
                }
                if (freq[s.charAt(si)] == 0) count++;
                freq[s.charAt(si)]++;
                si++;
            }
        }
        return ans;
    }
}
