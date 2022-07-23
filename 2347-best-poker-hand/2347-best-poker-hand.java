class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer,ArrayList<Character>> hm=new HashMap<>();
        for(int i=0;i<ranks.length;i++){
            if(!hm.containsKey(ranks[i])){
                hm.put(ranks[i],new ArrayList<>());
            }
            hm.get(ranks[i]).add(suits[i]);
        }
        
        
        for(int key:hm.keySet()){
            if(hm.get(key).size()>=3){
                return "Three of a Kind";
            }
            else if(hm.get(key).size()==2){
                return "Pair";
            }
        }
        
        char ch=suits[0];
        for(int i=1;i<ranks.length;i++){
            if(hm.get(ranks[i]).get(0)!=ch){
                return "High Card";
            }
        }
        
        return "Flush";
        
    }
}