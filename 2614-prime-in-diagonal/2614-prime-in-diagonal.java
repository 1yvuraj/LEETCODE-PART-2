class Solution {
    public int diagonalPrime(int[][] nums) {
        int max=-(int)1e9;
        int count=0;
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
           list.add(nums[i][i]);
           list.add(nums[i][nums.length - i - 1]);
        }
        Collections.sort(list);
        for(int i=list.size()-1;i>=0;i--){
            if(Prime(list.get(i))){
                if(list.get(i)==1)return 0;
                return list.get(i);
            }
        }
        return 0;
    }
     public boolean  Prime(int val) {
         int count=0;
         for(int i=2;i<val;i++){
             if(val%i==0)count++;
         }
        
         return count==0;
     }
    
}