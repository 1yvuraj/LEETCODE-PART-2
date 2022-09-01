class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int c=matrix[0].length-1;
        int r=0;
        int count=matrix[0].length*matrix.length;
        while(count-->0){
            if(r<matrix.length && c>=0 && matrix[r][c]==target)return true;
            else if(r<matrix.length && c>=0 && matrix[r][c]<target) r++;
            else c--;
        }
        return false;
    }
}