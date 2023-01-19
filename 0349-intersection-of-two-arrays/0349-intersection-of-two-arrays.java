class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean>map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]) == false){
                map.put(nums1[i],true);
            }
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) == true){
                res.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        
         int[] resArr = new int[res.size()];
        for(int i=0;i<resArr.length;i++){
            resArr[i]=res.get(i);
        }
         return resArr;
    }
}