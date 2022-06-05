class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        help(root);  
    }
    public void help(TreeNode root) {
        if(root==null)return ;
        help(root.right);
        help(root.left);
        root.left=null;  
        root.right=prev;
        prev=root;
    }
}
