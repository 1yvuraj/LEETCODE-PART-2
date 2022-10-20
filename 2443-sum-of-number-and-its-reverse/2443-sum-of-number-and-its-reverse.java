class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            int a=reverse(i);
            if(i+a==num){
                return true;
            }
            
        }
        return false;
    }
    public int reverse(int num) {
       int ans=0;
       while(num!=0){
           int rem=num%10;
           ans=rem+ans*10;
           num/=10;
           
       }
        return ans;
    }
}
