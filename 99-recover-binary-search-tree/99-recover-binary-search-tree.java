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
    ArrayList<Integer>ans=new ArrayList<>();
    int i=0;
    public void recoverTree(TreeNode root) {
        ans=new ArrayList<>();
        i=0;
        help(root);
        Collections.sort(ans);
        help1(root);
    }
    public void help(TreeNode root) {
       if(root==null)return;
       help(root.left);
       ans.add(root.val);
       help(root.right);
        
    }
    public void help1(TreeNode root) {
       if(root==null)return;
       help1(root.left);
       if(root.val!=ans.get(i)){
          root.val=ans.get(i);
       }
       i++;
       help1(root.right);
        
    }
}

