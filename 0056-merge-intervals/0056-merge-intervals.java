class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] val : intervals) {
            int start = val[0];
            int end = val[1];
            if (ans.size() == 0) {
                ans.add(new int[] { start, end });
            } else {
                int[] arr = ans.get(ans.size() - 1);
                if (val[0] <= arr[1]) {
                    arr[1] = Math.max(arr[1], val[1]);
                } else {
                    ans.add(val);
                }
            }
        }
        int[][] arr = new int[ans.size()][2];
        for (int i = 0; i < arr.length; i++) {
            int[] a = ans.get(i);
            arr[i][0] = a[0];
            arr[i][1] = a[1];
        }
        return arr;
    }
}
