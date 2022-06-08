class Solution {
    public int removePalindromeSub(String s) {
       int c=0;
        int l=0;
        int h=s.length()-1;
        while(l<h)
        {
            if(s.charAt(l)==s.charAt(h))
            {
                l++;
                h--;
                 
            }else{
                //c+=2;
                l++;
                h--;
                c+=1;
            }
        }
        return c>0?2:1;
    }
}