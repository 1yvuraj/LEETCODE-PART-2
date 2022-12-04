class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long count=0;
        int i=0,j=skill.length-1;
        long tar=skill[i]+skill[j];
        while(i<j){
            if(skill[i]+skill[j]==tar){
                count=count+skill[i]*skill[j];
                i++;
                j--;
            }else{
                return -1;
            }
            
        }
        return count;
        
    }
}