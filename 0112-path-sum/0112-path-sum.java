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
    boolean b = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        help(root, targetSum);
        return b;
    }

    public void help(TreeNode root, int targetSum) {
       if(root==null)return;
       if(root.left==null && root.right==null && targetSum==root.val)b=true;
       help(root.left,targetSum-root.val);
       help(root.right,targetSum-root.val);
    }
}
