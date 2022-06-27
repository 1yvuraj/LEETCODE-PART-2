class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        int pipe=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='*'&&pipe%2==0)
            {
                count++;
            }else if(s.charAt(i)=='|'){
                pipe++;
            }
        }

        return count;
    }
}
