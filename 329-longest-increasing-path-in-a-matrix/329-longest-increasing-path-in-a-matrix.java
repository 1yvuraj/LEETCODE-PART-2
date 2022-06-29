class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[n][m];
        LinkedList<Integer>q=new LinkedList<>();
        int[][]dir={{-1,0},{0,-1},{0,1},{1,0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < dir.length; d++) {
                    int r=i+dir[d][0];
                    int c=j+dir[d][1];
                    if(r>=0 && c>=0 && r<n && c<matrix[0].length && matrix[r][c]<matrix[i][j]){
                        ans[i][j]++;
                    }
                    
                }
                if(ans[i][j]==0){
                    q.addLast(i*matrix[0].length+j);
                }
            }
        }
        int level=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0)
            {
                int rem=q.removeFirst();
                int sr=rem/m;
                int sc=rem%m;
                for (int d = 0; d < dir.length; d++) {
                    int r=sr+dir[d][0];
                    int c=sc+dir[d][1];
                    if(r>=0 && c>=0 && r<n && c<matrix[0].length && matrix[r][c]>matrix[sr][sc]&&--ans[r][c]==0){
                        q.addLast(r*m+c);
                    }
                    
                }
                
            }
            level++;
        }
        return level;
    }
}
