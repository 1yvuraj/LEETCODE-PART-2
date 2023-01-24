class Solution {
    public int alternateDigitSum(int n) {
        int N=n;
        int digit=0;
        int sum=0;
        int add=1;
        while(N!=0){
            digit++;
            N/=10;
        }
        digit--;
        while(n!=0){
            int mostSignificant = n /(int)Math.pow(10, digit);
            sum+=(mostSignificant)*add;
            n-= mostSignificant*Math.pow(10,digit);
            add*=-1;
            digit--;
        }
        return sum;
        
    }
}