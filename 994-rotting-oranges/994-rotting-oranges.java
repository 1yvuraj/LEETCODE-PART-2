class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    list.addLast(i * m + j);
                }
            }
        }
        if(fresh==0)return 0;
        while (list.size() > 0) {
            int size = list.size();

            while (size-->0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        list.addLast(r * m + c);
                        fresh--;
                        if (fresh == 0) {
                            return time + 1;
                        }
                    }
                }
                
            }
            time++;
        }
        return -1;
    }
}
