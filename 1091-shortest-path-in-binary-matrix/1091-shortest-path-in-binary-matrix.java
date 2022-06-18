class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<Integer> list = new LinkedList<>();
        int m = grid[0].length;
        int n = grid.length;
        list.add(0);
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }

        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
        int time = 1;
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;
                 if (sr == n - 1 && sc == m - 1) {
                            return time ;
                        }
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        list.add(r * m + c);
                        
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
