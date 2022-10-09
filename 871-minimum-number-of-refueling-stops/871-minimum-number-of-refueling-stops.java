class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int distace=startFuel;
        int idx=0;
        int ans=0;
        while(distace<target){
            while(idx<stations.length && stations[idx][0]<=distace){
                q.add(stations[idx][1]);
                idx++;
            }
            if(q.isEmpty())return -1;
            distace+=q.remove();
            ans++;
        }
        return ans;
    }
}
