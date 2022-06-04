class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> smallans = new ArrayList<>();
        boolean[][] boxes = new boolean[n][n];
        nqueen_01(boxes, n, 0, ans, smallans);
        return ans;
    }
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {
         int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        //int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = boxes.length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= n; rad++) {
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (boxes[x][y]) return false;
                } else break;
            }
        }
        return true;
    }

    public static int nqueen_01(boolean[][] boxes, int tnq, int bno, List<List<String>> ans, ArrayList<String> smallans) {
        if (tnq == 0) {
            ArrayList<String> base = new ArrayList<>(smallans);

            ans.add(base);
            return 1;
        }
        int count = 0, n = boxes.length;
        for (int bidx = bno; bidx < n * n; bidx++) {
            int r = bidx / n, c = bidx % n;

            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                String psf="";
                for (int i = 0; i < boxes.length; i++) {
                    if (i == c) {
                        psf += "Q";
                    } else {
                        psf += ".";
                    }
                }
                smallans.add(psf);
                count += nqueen_01(boxes, tnq - 1, bidx + 1, ans, smallans);
                smallans.remove(smallans.size() - 1);
                boxes[r][c] = false;
            }
        }
        return count;
    }
}
