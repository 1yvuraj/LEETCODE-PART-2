class Solution {

    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (help(board, word, i, j, 0, visit)) return true;
                }
            }
        }
        return false;
    }

    public boolean help(char[][] board, String word, int i, int j, int x, boolean[][] visit) {
        if (x == word.length()) return true;
        if (j < 0 || i < 0 || i >= board.length || j >= board[0].length||visit[i][j]) return false;
        if (board[i][j] != word.charAt(x)) return false;
        boolean res = false;
        visit[i][j]=true;
        res = res || help(board, word, i + 1, j, x + 1, visit) || help(board, word, i, j + 1, x + 1, visit) || help(board, word, i - 1, j, x + 1,visit) || help(board, word, i, j - 1, x + 1,visit);
        visit[i][j]=false;
        return res;
    }
}
