class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int si=matrix.length-1,ei=0;
        while(si>=0 && ei<matrix[0].length){
            if(matrix[si][ei]==target)return true;
            else if(matrix[si][ei]<target)ei++;
            else si--;
        }
        return false;
    }
}