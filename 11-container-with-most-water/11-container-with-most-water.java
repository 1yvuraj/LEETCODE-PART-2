class Solution {
    public int maxArea(int[] height) {
       int l=0,r=height.length-1;
        int max=-(int)1e9;
        while(l<=r){
            int area=(r-l)*Math.min(height[l],height[r]);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
            max=Math.max(max,area);
        }
        return max;
    }
}