class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        //returning 0 if the length of the array is 0 because binary tree should is not possible.
        if(n == 0)
            return 0;
        //sort will help to track the elements
        Arrays.sort(arr);
        
        //map will remember for already occured elements
        HashMap<Integer, Long> mp = new HashMap<>();
        
        //i will not change so treating like a constant only
        int i = 0;
        for(; i < n; i++){
            //count is 1(l is for long) because every element is a tree in itself
            long count = 1l;
            for(int j = 0; j < i; j++){
                //this will check is arr[j] can be the child of arr[i] and if yes then we check if
                //arr[i]/arr[j] had an element in map then we can say it is the valid relation
                //else count is 1 only.
                if((arr[i] % arr[j] == 0) && (mp.containsKey(arr[i] / arr[j]) == true)){
                    // this line calculating count = 1 + (count of ways generating arr[j] and arr[i]/arr[j])
                    count += mp.get(arr[j]) * mp.get(arr[i] / arr[j]); 
                }
            }
            mp.put(arr[i], count);
        }
        long ans = 0;
        //adding up all the values(counts) of the map values to get the total number of trees geneated
        for(Map.Entry<Integer, Long> entry: mp.entrySet()){
            ans += (entry.getValue() % 1000000007);
        }
        return (int)(ans % 1000000007);
    }
}