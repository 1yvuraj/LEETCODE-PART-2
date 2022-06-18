class Solution {
    public int[][] updateMatrix(int[][] grid) {
        LinkedList<Integer> list = new LinkedList<>();
        int[][]visit=new int[grid.length][grid[0].length];
        int m = grid[0].length;
        int n = grid.length;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    list.add(i*m+j);
                    visit[i][j]=2;
                }
            }
        }
        
        int[][] dir = { { -1, 0 },{ 0, 1 },{ 1, 0 }, { 0, -1 }};
        int time = 1;
        while (list.size() > 0) {
            int size = list.size();
            while (size-->0) {
                int rem = list.removeFirst();
                int sr = rem / m;
                int sc = rem % m;
                
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && visit[r][c] != 2) {
                        grid[r][c] = grid[sr][sc]+1;
                        visit[r][c]=2;
                        list.add(r * m + c);
                    }
                }
            }
            
        }
        return grid;
    }
}
