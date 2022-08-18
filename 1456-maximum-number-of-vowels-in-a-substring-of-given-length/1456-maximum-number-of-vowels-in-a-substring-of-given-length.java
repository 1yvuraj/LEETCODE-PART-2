class Solution {

    public int maxVowels(String s, int k) {
       

        int n = s.length(), si = 0, ei = 0, count = 0, len = 0;
       

        while (ei < n) {
            //kuki distict character dekhne hai to zero kia hai
            if (s.charAt(ei) == 'a' || s.charAt(ei) == 'i' || s.charAt(ei) == 'o' || s.charAt(ei) == 'u' || s.charAt(ei) == 'e') {
                count++;
            }

            ei++;
            //kuki do distint hone chia
            if (ei - si == k) {
                //matlb 2 distint character bache hai to count decrese
                len = Math.max(count, len);
                if (s.charAt(si) == 'a' || s.charAt(si) == 'i' || s.charAt(si) == 'o' || s.charAt(si) == 'u' || s.charAt(si) == 'e') {
                    count--;
                }
                si++;
            }

           
        }
        return len;
    }
}
