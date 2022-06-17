/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
      int cameras = 0;
    
   public  int MinCamerasInBT_(TreeNode node){
        if(node == null)return 1;
        
        int left = MinCamerasInBT_(node.left);
        int right = MinCamerasInBT_(node.right);
        
        if(left == -1 || right == -1){
            cameras++;
            return 0;
        }
        
        if(left == 0 || right == 0){
            return 1;
        }
        return -1;
    }
    
    public int minCameraCover(TreeNode root) {
        //int cameras = 0;
        if(MinCamerasInBT_(root) == -1)cameras++;
        return cameras;
    }
}