class Solution {

    public int maxEnvelopes(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (p, q) -> p[0] == q[0] ? q[1] - p[1] : p[0] - q[0]);
        // O(NlogN)

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(list, arr[i][1]);
            if (idx == list.size()) list.add(arr[i][1]); else list.set(idx, arr[i][1]);
        }

        return list.size();
    }

    private  int binarySearch(List<Integer> list, int num) {
        int li = 0, ri = list.size();
        while (li < ri) {
            int mid = (li + ri) / 2;
            if (num <= list.get(mid))
                ri = mid;
            else
                li = mid + 1;
        }

        return li;
    }

}
