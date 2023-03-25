class Solution {
    public int maxArea(int[] height) {
        int max=-(int)1e9;
        int i=0;int j=height.length-1;
        while(i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]>height[j])j--;
            else i++;
        }
        return max;
    }
}