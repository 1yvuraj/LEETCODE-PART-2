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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                if(prev != null && prev.val > cur.val) {
                    if(n1 == null) {
                        n1 = prev;
                        n2 = cur;
                    } else {
                        n2 = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            } else {
                TreeNode p = cur.left;
                while (p.right != null && p.right != cur) {
                    p = p.right;
                }
                if (p.right == null) {
                    p.right = cur;
                    cur = cur.left;
                }
                if(p.right == cur){
                    if (prev != null && prev.val > cur.val) {
                        if (n1 == null) {
                            n1 = prev;
                            n2 = cur;
                        } else {
                            n2 = cur;
                        }
                    }
                    prev = cur;
                    p.right = null;
                    cur = cur.right;
                }
            }
        }
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
        
    }
}

