class Solution {
    public int countHousePlacements(int n) {
        long zeroes = 1;
      long ones = 1;
      for (int i = 2; i <= n; i++) {
         long nzeroes = ones %((int)1e9+7);
         long nones = (ones + zeroes)%((int)1e9+7);

         zeroes = nzeroes%((int)1e9+7);
         ones = nones%((int)1e9+7);
      }
      return (int)(((zeroes+ones)*(zeroes+ones))%((int)1e9+7));
    }
}
