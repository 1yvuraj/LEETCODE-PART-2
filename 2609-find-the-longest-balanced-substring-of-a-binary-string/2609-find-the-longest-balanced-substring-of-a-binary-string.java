class Solution {
    public int findTheLongestBalancedSubstring(String s) {
       
         int max=0;
        for(int i=0;i<s.length();i++){
            int zero=0;
             int one=0;
       
            if(s.charAt(i)=='0'){
            while(i<s.length() && s.charAt(i)=='0'){
                zero++;
                i++;
            }
            while(i<s.length() && s.charAt(i)=='1'){
                one++;
                i++;
            }
            --i;
            int len=Math.min(one,zero);
            max=Math.max(max,2*len);
            
            }
        }
        return max;
    }
}