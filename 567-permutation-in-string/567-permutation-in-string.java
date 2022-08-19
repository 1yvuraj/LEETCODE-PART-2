class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counter1 = new int[26];
        int[] counter2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            counter1[s1.charAt(i) - 'a'] += 1;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            counter2[s2.charAt(i) - 'a'] += 1;
            
            if (i >= s1.length()) {
                counter2[s2.charAt(i - s1.length()) - 'a'] -= 1;
            }
            
            if (Arrays.equals(counter1, counter2)) {
                return true;
            }
        }
        
        return false;
    }
}