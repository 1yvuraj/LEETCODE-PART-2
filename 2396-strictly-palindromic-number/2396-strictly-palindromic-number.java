class Solution {

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String ans = "";
            ans += getValueInBase(n, i);
            if (!checkPalindrome(ans)) return false;
        }
        return true;
    }

    public int getValueInBase(int n, int b) {
        int rv = 0;

        int p = 1;
        while (n > 0) {
            int d = n % b;
            n = n / b;
            rv += p * d;
            p = p * 10;
        }

        return rv;
    }

    public boolean checkPalindrome(String s) {
        // reverse the given String
        String reverse = new StringBuffer(s).reverse().toString();

        // check whether the string is palindrome or not
        if (s.equals(reverse)) return true; else return false;
    }
}
