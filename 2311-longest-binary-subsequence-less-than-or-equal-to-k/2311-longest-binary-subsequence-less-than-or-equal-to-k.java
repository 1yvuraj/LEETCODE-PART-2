class Solution {
    public int longestSubsequence(String s, int k) {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0'){
                count++;
            }
        }
        int p=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='1'){
                sum+=Math.pow(2,p);
                p++;
                if(sum<=k)
                {
                    count++;
                }else{
                    return count;
                }
            }
            else{
                p++;
            }
        }
        return count;
    }
}