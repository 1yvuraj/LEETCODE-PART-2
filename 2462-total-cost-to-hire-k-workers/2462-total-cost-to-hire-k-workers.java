class Solution {

    public long totalCost(int[] cost, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long sum = 0L;
        int i = 0;
        int j = cost.length - 1;
        for (i = 0; i < candidates; i++) {
            left.add(cost[i]);
        }
        for (j = cost.length - 1; j >= cost.length - candidates && j>=i; j--) {
            right.add(cost[j]);
        }
        int round = 0;
        while (i <= j && round < k) {
            if (left.peek() <= right.peek()) {
                sum += left.poll();
                left.add(cost[i]);
                i++;
            } else {
                sum += right.poll();
                right.add(cost[j]);
                j--;
            }
            round++;
        }
        while (round < k) {
            if (left.size() == 0) sum += right.poll(); 
            else if (right.size() == 0) sum += left.poll();
            else if(left.peek() <= right.peek())sum += left.poll();
            else sum += right.poll();
            
            round++;
        }
        return sum;
    }
}
