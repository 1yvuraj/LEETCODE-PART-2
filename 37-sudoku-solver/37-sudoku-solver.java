class Solution {

    public static void solveSudoku(char[][] board) {
        int n = board.length;
        ArrayList<Integer> idx = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    idx.add(i * n + j);
                }
            }
        }
        sudukusolver(board, idx, 0);
    }

    public static boolean sudukusolver(char[][] board, ArrayList<Integer> ans, int idx) {
        if (idx == ans.size()) {
            return true;
        }
        int r = ans.get(idx) / 9;
        int c = ans.get(idx) % 9;
        for (int i = 1; i <= 9; i++) {
            if (ispossible(board, r, c, i)) {
                board[r][c] = (char) ('0' + i);
                if (sudukusolver(board, ans, idx + 1)) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    public static boolean ispossible(char[][] board, int r, int c, int num) {
        int n = board.length;
        for (int i = 0; i < 9; i++) {
            if (board[r][i] - '0' == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][c] - '0' == num) return false;
        }
        r = (r / 3) * 3;
        c = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + r][j + c] - '0' == num) return false;
            }
        }
        return true;
    }
}
