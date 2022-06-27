class Solution {
    public int countAsterisks(String s) {
        boolean b=false;
        int max=-(int)1e9;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
           
            
                
                if(s.charAt(i)=='|'){
                    b=!b;
                }
                if(!b && s.charAt(i)=='*'){
                    count++;
                }
            
           
            
        }
         
        return count;
    }
}