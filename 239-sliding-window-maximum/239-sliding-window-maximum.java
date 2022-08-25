class Solution {

    //     private class pair implements Comparable<pair> {
    //         int value;
    //         int idx;
    //         pair(int value, int idx) {
    //             this.value = value;
    //             this.idx = idx;
    //         }

    //         public int compareTo(pair o) {
    //             return o.value - this.value;
    //         }
    //     }
    //     public int[] maxSlidingWindow(int[] arr, int k) {
    //         PriorityQueue<pair> pq = new PriorityQueue<>();
    //         int y = 0;
    //         int[] ans = new int[arr.length - k + 1];
    //         for (int i = 0; i < arr.length; i++) {
    //             while (pq.size() > 0 && pq.peek().idx <= i - k) {
    //                 pq.remove();
    //             }
    //             pq.add(new pair(arr[i], i));
    //             if (i >= k - 1) ans[y++] = pq.peek().value;
    //         }
    //         return ans;
    //     }

    public int[] maxSlidingWindow(int[] arr, int k) {
        LinkedList<Integer> dq = new LinkedList<>();
        int y = 0;
        int[] ans = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            while (dq.size() > 0 && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            while (dq.size() > 0 && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) ans[y++] = arr[dq.getFirst()];
        }
        return ans;
    }
}
