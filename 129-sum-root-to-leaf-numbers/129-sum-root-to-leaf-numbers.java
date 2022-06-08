
class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        help(root,0);
        return sum;
    }
    public void help(TreeNode root,int val) {
        if(root==null)
        {
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            val=10*val+root.val;
            sum+=val;
        }
        help(root.left,10*val+root.val);
        help(root.right,10*val+root.val);
    }
}