class Solution {
    int[] arr;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        arr = new int[26];
        rank = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            rank[i] = 1;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int x = find(str.charAt(0) - 'a');
                int y = find(str.charAt(3) - 'a');
                if (x == y) {
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int x1, int y1) {
        int x = find(x1);
        int y = find(y1);
        if (rank[x] > rank[y]) {
            arr[y] = x;
        } else if (rank[x] < rank[y]) {
            arr[x] = y;
        } else {
            arr[x] = y;
            rank[x]++;
        }
    }

    public int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        int temp = find(arr[x]);
        arr[x] = temp;
        return temp;
    }
}
