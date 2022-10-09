class Solution {

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int val : arr) {
            if (val != 0) {
                if (hmap.containsKey(val)) {
                    hmap.put(val, hmap.get(val) + 1);
                } else {
                    hmap.put(val, 1);
                }
            }
        }

        for (int val : arr) {
            if(hmap.containsKey(val) && hmap.containsKey(2*val)){
                hmap.put(val,hmap.get(val)-1);
                 hmap.put(val*2,hmap.get(2*val)-1);
                 if(hmap.get(val)==0)hmap.remove(val);
                 if(hmap.get(2*val)==0)hmap.remove(2*val);
                
            }
        }

        return hmap.size() == 0;
    }
}
