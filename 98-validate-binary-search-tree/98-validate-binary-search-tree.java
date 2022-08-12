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
    public class pair{
        boolean isbst=true;
        Long max=Long.MIN_VALUE;
        Long min=Long.MAX_VALUE;
        pair(boolean isbst,long max,long min)
        {
            this.isbst=isbst;
            this.max=max;
            this.min=min;
        }
       
    }
    public boolean isValidBST(TreeNode root) {
       pair ans= help(root);
        return ans.isbst;
    }
     public pair help(TreeNode root) {
         if(root==null)
         {
             pair ans=new pair(true,Long.MIN_VALUE,Long.MAX_VALUE);
             return ans;
         }
         pair l=help(root.left);
         pair r=help(root.right);
         boolean b=(l.isbst)&&(r.isbst)&&(root.val>l.max&&root.val<r.min);
          long ma=Math.max(root.val,Math.max(l.max,r.max));
          long mn=Math.min(root.val,Math.min(l.min,r.min));
         
         
         return new pair(b,ma,mn);
    }
}