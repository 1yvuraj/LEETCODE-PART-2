class Solution {
    public int carFleet(int t, int[] position, int[] speed) {
        int[][]arr=new int[position.length][2];
        int n=speed.length;
        for(int i=0;i<position.length;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        double prev=-0.1;
        
        int count=0;
        for(int i=n-1;i>=0;i--){
            double cur=(t-arr[i][0]*1.0)/arr[i][1];
            if(cur>prev){
                prev=cur;
                count++;
            }
        }
        return count;
    }
}