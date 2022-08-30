class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        for(int i=0;i<answers.length;i++){
            if(map.containsKey(answers[i])){
                
                map.put(answers[i],map.get(answers[i])+1);
                
            }else {
                  map.put(answers[i],1);
                 ans+=answers[i]+1;
            }
            if(map.get(answers[i])==(answers[i]+1))map.remove(answers[i]);
            
        }
        return ans;
    }
}