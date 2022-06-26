// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
        
//        return  maxScores(cardPoints,0,cardPoints.length-1,k);
//     }
//      public int maxScores(int[] cardPoints,int l,int r, int k) {
//          if(k==0)
//          {
//              return 0;
//          }
        
//         int f1= cardPoints[l]+maxScores(cardPoints,l+1,r,k-1);
//          int f2= cardPoints[r]+maxScores(cardPoints,l,r-1,k-1);
//          return Math.max(f1,f2);
//      }
// }
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
     for(int i=0;i<k;i++)
     {
         sum+=cardPoints[i];
     }
        int c=1;
        int l=k-1;
        int r=cardPoints.length-1;
        int max=sum;
    while(c<=k)
    {
        sum-=cardPoints[l];
        sum+=cardPoints[r];
        max=Math.max(max,sum);
        ++c;
        l--;
        r--;
    }
         
        return max;
    }
     
}