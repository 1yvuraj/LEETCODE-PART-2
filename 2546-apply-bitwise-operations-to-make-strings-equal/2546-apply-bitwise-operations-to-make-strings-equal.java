class Solution {

    public boolean makeStringsEqual(String s, String target) {
        int count = 0;
        int count1 = 0;
        if(s.equals(target))return true;
        for (int i = 0; i < s.length(); i++) {
            if (target.charAt(i)=='0') count++;
        }
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='0') count1++;
        }
        if(count == s.length())return false;
        else if(count1 == s.length())return false;
        return true;
    }
}
