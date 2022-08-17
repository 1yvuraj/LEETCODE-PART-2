class Solution {
    public int maxArea(int[] height) {
       int l=0;
       int r=height.length-1;
        int maxarea=0;
        
        while(l<r){
           maxarea=Math.max(maxarea,(r-l)*Math.min(height[l],height[r])) ;
          if(height[l]<height[r])l++;
          else r--;
        }
        return maxarea;
    }
}