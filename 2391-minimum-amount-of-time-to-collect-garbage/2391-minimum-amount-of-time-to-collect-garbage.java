class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        int countM = 0;
        int countG = 0;
        int countP = 0;
        int M = 0;
        int G = 0;
        int P = 0;
        int ans = 0;
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                char ch = garbage[i].charAt(j);
                if (ch == 'M') {
                    countM++;
                    M = i;
                }
                if (ch == 'G') {
                    countG++;
                    G = i;
                }
                if (ch == 'P') {
                    countP++;
                    P = i;
                }
            }
        }
        ans += M == 0 ? countM : countM + travel[M - 1];
        ans += G == 0 ? countG : countG + travel[G - 1];
        ans += P == 0 ? countP : countP + travel[P - 1];
        return ans;
    }
}