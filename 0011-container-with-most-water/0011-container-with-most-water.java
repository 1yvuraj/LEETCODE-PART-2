class Solution {
    public int maxArea(int[] height) {
        int si=0,ei=height.length-1;
        int max=-(int)1e9;
        while(si<ei){
            max=Math.max(max,Math.min(height[si],height[ei])*(ei-si));
            if(height[ei]<height[si]){
                ei--;
                
            }else{
                si++;
            }
        }
        return max;
    }
}