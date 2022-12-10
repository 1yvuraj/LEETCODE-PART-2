class Solution {
    public int maximumValue(String[] strs) {
        int max=-(int)1e9;
        for(int i=0;i<strs.length;i++){
            int c=0;
            int k=0;
            for(int j=0;j<strs[i].length();j++){
                if(Character.isDigit(strs[i].charAt(j))){
                    c++;
                   
                }else {
                    k++;
                }
            }
            if(c>0 && k>0 || c==0 && k>0){
                max=Math.max(max,strs[i].length());
            }else{
               
                max=Math.max(max,Integer.parseInt(strs[i]));
            }
            
        }
        return max;
    }
}