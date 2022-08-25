class Solution { 
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) ->{
            return arr[y]-arr[x];
        });
        int y=0;
        int[] ans = new int[arr.length- k+1];
        for(int i=0;i<arr.length;i++){
            while(pq.size()>0 && pq.peek()<=i-k){
                pq.remove();
            }
            pq.add(i);
            if(i>=k-1)ans[y++]=arr[pq.peek()];
            
        }
        return ans;
    }
}
