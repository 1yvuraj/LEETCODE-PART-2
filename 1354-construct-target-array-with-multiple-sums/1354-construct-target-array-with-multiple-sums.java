class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0; i < target.length; i++) {
            pq.add((long) target[i]);
            sum += target[i];
        }
        while (pq.peek() != 1) {
            long max = pq.poll();
            sum = sum - max;
            if (sum <= 0 || sum >= max) return false;
            max = max % sum;

            sum += max;
            pq.add(max > 0 ? max : sum);
        }
        return true;
    }
}
