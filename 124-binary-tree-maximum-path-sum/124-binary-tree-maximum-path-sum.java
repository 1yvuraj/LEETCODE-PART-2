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
class Solution
{ 
    public int maxPathSum(TreeNode root) {
        int[]max=new int[1];
        max[0]=-(int)1e9;
        help(root,max);
         
        return max[0];
    }
    public int help(TreeNode root,int[]max) {
        if (root == null) return 0;
        int l = help(root.left,max);
        int r = help(root.right,max);
        int ldash = Math.max(0, l);
        int rdash = Math.max(0, r);
        int sumNTN = ldash + rdash + root.val;
        max[0] = Math.max(max[0], sumNTN);
        return Math.max(ldash, rdash) + root.val;
    }
}