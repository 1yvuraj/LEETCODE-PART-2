class Solution {
    public int totalNQueens(int n) {
        boolean[][] boxes=new boolean[n][n];
        return nqueen_01(boxes,n,0,"");
    }
    public  boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
         int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        //int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = boxes.length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (boxes[x][y])
                        return false;
                } else
                    break;
            }
        }
        return true;
    }

    public  int nqueen_01(boolean[][] boxes, int tnq, int bno, String psf) {
        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;
            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nqueen_01(boxes, tnq - 1, bidx + 1, psf + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }
}