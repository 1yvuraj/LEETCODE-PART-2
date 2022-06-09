
class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        BST(root);
        return root;
    }
     public void BST(TreeNode root) {
         if(root==null)
         {
             return;
         }
        BST(root.right);
         sum+=root.val;
        root.val=sum;
        BST(root.left);
        
         
    }
}