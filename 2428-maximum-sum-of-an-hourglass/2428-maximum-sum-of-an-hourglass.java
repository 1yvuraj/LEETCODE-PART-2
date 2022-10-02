class Solution {

    public int maxSum(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                max=Math.max(max,maxSum(grid,i,j));
            }
        }
        return max;
    }

    public int maxSum(int[][] grid, int k, int l) {
        int max = 0;
        for (int i = k; i < k + 3; i++) {
            for (int j = l; j < l + 3; j++) {
                max+=grid[i][j];
            }
        }
        max-=grid[k+1][l];
        max-=grid[k+1][l+2];
        return max;
    }
}
