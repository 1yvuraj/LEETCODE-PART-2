class Solution {

    public int subarrayGCD(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
           int curnum=nums[i];
          for(int j=i;j<nums.length;j++){
              curnum=check(curnum,nums[j]);
              if(curnum==k)count++;
              
          }
        }
        return count;
    }

    public int check(int n1, int n2) {
       if(n2==0)return n1;
        return check(n2,n1%n2);
    }
   
}
