class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[]ans=new int[2];
        ans[0]=-(int)1e5;
        ans[1]=(int)1e5;
        int max=-(int)1e9;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<nums.size();i++){
            int[]arr={nums.get(i).get(0),0,i};
            max=Math.max(max,nums.get(i).get(0));
            pq.add(arr);
        }
        while(true){
            int[]arr=pq.poll();
            if(ans[1]-ans[0]>max-arr[0]){
                ans[0]=arr[0];
                ans[1]=max;
            }
            arr[1]++;
            List<Integer>c1=nums.get(arr[2]);
            if(arr[1]==c1.size())break;
            else{
                arr[0]=c1.get(arr[1]);
                max=Math.max(max,c1.get(arr[1]));
                pq.add(arr);
            }
        }
        return ans;
    }
}