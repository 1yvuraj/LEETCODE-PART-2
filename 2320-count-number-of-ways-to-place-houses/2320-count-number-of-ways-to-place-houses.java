class Solution {

    public int countHousePlacements(int n) {
        long[]dp1=new long[n+1];
        long[]dp2=new long[n+1];
        dp1[1]=1;
        dp2[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp1[i]=dp2[i-1]%1000000007;
            dp2[i]=dp1[i-1]%1000000007+dp2[i-1]%1000000007;
            
        }
        long sum=((dp1[n]+dp2[n])*(dp1[n]+dp2[n]))%1000000007;
        return (int)sum;
    }
}
