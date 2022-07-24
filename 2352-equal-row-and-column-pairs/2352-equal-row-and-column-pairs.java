class Solution {
    public int equalPairs(int[][] grid) {
        int[][] transpose = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for(int j=0;j<grid.length;j++){
                transpose[j][i]=grid[i][j];
            }
         }
         int c=0;
         for (int i = 0; i < transpose.length; i++) {
            for(int j=0;j<transpose.length;j++){
               if(Arrays.equals(transpose[i],grid[j]))c++; 
            }
         }
        return c;
    }
}
