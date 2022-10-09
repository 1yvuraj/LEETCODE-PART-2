class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int start=0;
        int end=logs[0][1];
        int time=end-start;
        int ans=logs[0][0];
        for(int i=1;i<logs.length;i++){
            if(logs[i][1]-logs[i-1][1]>time){
                time=logs[i][1]-logs[i-1][1];
                ans=logs[i][0];
            }else if(logs[i][1]-logs[i-1][1]==time){
                if(ans>logs[i][0]){
                    ans=logs[i][0];
                }
            }
        }
        return ans;
    }
}