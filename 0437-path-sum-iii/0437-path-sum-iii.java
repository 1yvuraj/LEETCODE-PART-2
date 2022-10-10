class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        ans=0;
        help1(root,targetSum);
        return ans;
    }
    public void help2(TreeNode root, long sum,int targetSum) {
        if(root==null)return;
        if(sum+root.val==targetSum)ans++;
        help2(root.left,sum+root.val,targetSum);
        help2(root.right,sum+root.val,targetSum);
        
    }
     public void help1(TreeNode root,int targetSum) {
        if(root==null)return;
        help2(root,0,targetSum);
        help1(root.left,targetSum);
        help1(root.right,targetSum);
        
    }
}