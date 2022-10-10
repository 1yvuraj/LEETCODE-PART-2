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
    int max = -(int) 1e9;
    public int maxPathSum(TreeNode root) {
        max = -(int) 1e9;
        help(root);
        return max;
    }
    public int help(TreeNode root) {
        if (root == null) return 0;
        int l = help(root.left);
        int r = help(root.right);
        int ldash = Math.max(0, l);
        int rdash = Math.max(0, r);
        int sumNTN = ldash + rdash + root.val;
        max = Math.max(max, sumNTN);
        return Math.max(ldash, rdash) + root.val;
    }
}