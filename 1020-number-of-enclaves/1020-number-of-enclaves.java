class Solution {
    int l = 0;
    boolean b=true;
    public int numEnclaves(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    l = 0;
                    b=true;
                    help(grid, i, j);
                    if(b)
                    count += l;
                }
            }
        }
        return count;
    }

    public void help(int[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length) {
           b=false;

            return;
        }
        if(grid[sr][sc] == 0){
            return;
        }
        grid[sr][sc] = 0;
        l++;
        help(grid, sr + 1, sc);
        help(grid, sr, sc + 1);
        help(grid, sr - 1, sc);
        help(grid, sr, sc - 1);
    }
}
