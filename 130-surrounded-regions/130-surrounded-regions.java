class Solution {
    public void solve(char[][] grid) {
        int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    if (grid[i][j] == 'O') {
                        help(grid, i, j,dir);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'v') {
                    grid[i][j] = 'O';
                } else {
                    grid[i][j] = 'X';
                }
            }
        }
    }

    public void help(char[][] grid, int row, int col,int[][]dir) {
        grid[row][col] = 'v';
        for(int d=0;d<dir.length;d++)
        {
            int r=row+dir[d][0];
            int c=col+dir[d][1];
            if (r >=0 && c>= 0 && r < grid.length && c< grid[0].length && grid[r][c]== 'O'){
                help(grid,r,c,dir);
            }
        }
    }
}
// class Solution {
//     public void solve(char[][] board) {
//         // Lengths of board
//         int n = board.length;
//         int m = board[0].length;
//         if(n==0 || m==0) return;
//         // The base cases
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(i==0 || j==0 || i==n-1 || j==m-1){
//                     dfs(i,j,board,n,m);
//                 }
//             }
//         }
//         //Final Iteration
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(board[i][j]=='#'){
//                     board[i][j] = 'O';
//                 }else{
//                     board[i][j] = 'X';
//                 }
//             }
//         }
//     }
//     public static void dfs(int i,int j,char[][] board,int n,int m){
//         if(i<0 || j<0 || i>n-1 || j>m-1 || board[i][j]!='O'){
//             return;
//         }
//         board[i][j]='#';
//         dfs(i+1,j,board,n,m);
//         dfs(i-1,j,board,n,m);
//         dfs(i,j+1,board,n,m);
//         dfs(i,j-1,board,n,m);
//     }
// }
