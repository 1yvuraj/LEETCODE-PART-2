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

    public TreeNode reverseOddLevels(TreeNode root) {
         help(root);
        return root;
    }

    public void help(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        q.add(root);
        int l=0;
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode rem = q.removeFirst();
                ans.add(rem);
                if (rem.left != null) {
                    q.addLast(rem.left);
                }
                if (rem.right != null) {
                   q.addLast(rem.right);
                }
            }
            if (l % 2 != 0) {
                int le = 0, r = ans.size() - 1;
                while (le < r) {
                    int temp = ans.get(le).val;
                    ans.get(le).val = ans.get(r).val;
                    ans.get(r).val = temp;
                    le++;
                    r--;
                }
                
            }
            ans = new ArrayList<>();
            l++;
        }
       
    }
}
