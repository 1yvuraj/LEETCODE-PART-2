class Solution {

    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = (int) 1e9;

        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        int ans=map.get(deck[0]);
        for(int i=0;i<deck.length;i++){
            ans=gcd(ans,map.get(deck[i]));
            if(ans<2)return false;
        }

        
        return true;
    }
     public int  gcd(int a,int b) {
       if(a==0)return b;
       return gcd(b%a,a); 
    }
}
