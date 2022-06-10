class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root,p,q);
    }
    public TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return null;
        }
        if(root.val==p.val || root.val==q.val)
        {
            return root;
        }
        TreeNode left=help(root.left,p,q);
        TreeNode right=help(root.right,p,q);
        
       if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
          return root;
       }
    }
}