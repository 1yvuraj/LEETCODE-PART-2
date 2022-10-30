class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String>ans=new ArrayList<>();
        
       
        for(int i=0;i<queries.length;i++){
           
            String s=queries[i];
            for(int j=0;j<dictionary.length;j++){
                String str=dictionary[j];
                 int count=0;
                for(int k=0;k<str.length();k++){
                    if(s.charAt(k)!=str.charAt(k))count++;
                }
                if(count<=2){
                    ans.add(queries[i]);
                    break;
                }
                
            }
            
            
        }
        
        return ans;
        
    }
}
