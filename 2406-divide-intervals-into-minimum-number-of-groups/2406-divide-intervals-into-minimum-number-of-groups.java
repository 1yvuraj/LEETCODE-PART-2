class Solution {
    public int minGroups(int[][] intervals) {
        int[]arr=new int[10000001];
        int ans=0;
        int max=0;
        for(int[]val:intervals){
           arr[val[0]]++;
           arr[val[1]+1]--;
        }
        for(int i=0;i<arr.length;i++){
            ans+=arr[i];
            max=Math.max(max,ans);
        }
        return max;
    }
}