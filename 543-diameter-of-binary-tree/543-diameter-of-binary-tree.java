
class Solution {
    int max=-(int)1e9;
    public int diameterOfBinaryTree(TreeNode root) {
        // int []max=new int[1];
        help(root);
        return max;
    }
    public int help(TreeNode root) {
        if(root==null)
        {
            return -1;
        }
        int l=help(root.left);
        int r=help(root.right);
        if(l+r+2>max){
            max=l+r+2;
        }
        return Math.max(l,r)+1;
    }
}