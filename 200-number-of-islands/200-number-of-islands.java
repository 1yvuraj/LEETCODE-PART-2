class Solution {
    int max = -(int) 1e9;
    int[] p;
    int[] rank;
    int ones = 0;

    public int numIslands(char[][] grid) {
        p = new int[grid.length * grid[0].length];
        rank = new int[grid.length * grid[0].length];
        int max = -(int) 1e9;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            rank[i] = 1;
        }
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]-'0' == 1) {
                 ans++;
                }
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]-'0' == 1) {
                   
                    int x = find(i * grid[0].length + j);
                    for (int d = 0; d < dir.length; d++) {
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c]-'0' == 1) {
                            int y = find(r * grid[0].length + c);
                            if (x != y) {
                                p[y] = x;
                                ans--;
                                rank[x] += rank[y];
                            }
                        }
                    }
                   
                }
            }
        }
        return ans;
    }

    public int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }
}

    
