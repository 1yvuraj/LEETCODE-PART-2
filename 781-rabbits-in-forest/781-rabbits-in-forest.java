class Solution {
    public int numRabbits(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int ans=0;
        for(int key:map.keySet()){
           ans+=(int)Math.ceil(map.get(key)*1.0/(key+1)*1.0)*(key+1);
        }
        return ans;
    }
}