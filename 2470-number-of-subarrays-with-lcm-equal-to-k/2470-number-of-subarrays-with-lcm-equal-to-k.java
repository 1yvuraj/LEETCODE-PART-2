class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=1;
            for(int j=i;j<nums.length;j++){
                sum=lcm(sum,nums[j]);
                count+=(sum==k)?1:0;
            }
        }
        return count;
    }
    public int gcd(int i, int j) {
       if(i==0)return j;
       return gcd(j%i,i);
    }
     public int lcm(int i, int j) {
      return (i*j)/gcd(i,j);
    }
}