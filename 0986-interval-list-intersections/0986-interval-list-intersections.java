class Solution {

    public int[][] intervalIntersection(int[][] intervalList1, int[][] intervalList2) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < intervalList1.length && j < intervalList2.length) {
            int max = Math.max(intervalList1[i][0], intervalList2[j][0]);
            int min = Math.min(intervalList1[i][1], intervalList2[j][1]);
            if (max <= min) {
                ans.add(new int[] { max, min });
            } 
            if (intervalList1[i][1] < intervalList2[j][1]) {
                i++;
            } else j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
