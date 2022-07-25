class Solution {
    int[] p;
    int[] r;

    public int findPar(int u) {
        return p[u] == u ? u : (p[u] = findPar(p[u]));
    }

    public int union(int x, int y) {
        if (x != y) {
            if (r[x] > r[y]) {
                p[y] = x;
            } else if (r[x] < r[y]) {
                p[x] = y;
            } else {
                p[x] = y;
                r[x]++;
            }
            return 0;
        } else {
            return 1;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int N = n+1;
        p = new int[N*N];
        r = new int[N*N];
        int count = 1;
        for (int i = 0; i < p.length; i++) {
            if (i / N == 0 || i / N == N - 1 || i % N == 0 || i % N == N - 1) {
                p[i] = 0;
            } else {
                p[i] = i;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '/') {
                    count += union(findPar(i * N + j + 1), findPar((i + 1) * N + j));
                } else if (s.charAt(j) == '\\') {
                    count += union(findPar(i * N + j), findPar((i + 1) * N + j + 1));
                }
            }
        }
        return count;
    }
//      public int regionsBySlashes(String[] grid) {
//         int n = grid.length;
//         int N = n + 1;
//         p = new int[N * N];
//         r = new int[N * N];
//         for (int i = 0; i < N * N; i++)
//             if (i / N == 0 || i % N == 0 || i / N == N - 1 || i % N == N - 1)
//                 p[i] = 0;
//             else
//                 p[i] = i;

//         int regions = 1;
//         for (int r = 0; r < n; r++) {
//             String s = grid[r];
//             for (int c = 0; c < s.length(); c++) {
//                 if (s.charAt(c) == '/')
//                     regions += union(findPar(r * N + c + 1), findPar((r + 1) * N + c));
//                 else if (s.charAt(c) == '\\')
//                     regions += union(findPar(r * N + c), findPar((r + 1) * N + c + 1));
//             }
//         }

//         return regions;
//     }

}
