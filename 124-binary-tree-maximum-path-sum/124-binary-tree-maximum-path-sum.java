
class Solution {
    int max=-(int)1e9;
    public int maxPathSum(TreeNode root) {
        help(root);
        return max;
    }
    public int help(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int left =help(root.left);
        int right =help(root.right);
        int ld=Math.max(0,left);
        int rd=Math.max(0,right);
        max=Math.max(max,ld+rd+root.val);
        return Math.max(ld,rd)+root.val;
    }
}