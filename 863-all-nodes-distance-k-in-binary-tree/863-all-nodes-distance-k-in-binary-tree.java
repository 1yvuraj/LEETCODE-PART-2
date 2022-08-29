/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void printKLevelsDown(TreeNode node, int k, TreeNode b, ArrayList<Integer> ans) {
        if (node == null || b == node) {
            return;
        }

        if (k == 0) {
            ans.add(node.val);
        }
        printKLevelsDown(node.left, k - 1, b, ans);
        printKLevelsDown(node.right, k - 1, b, ans);
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.val == data) {
            ArrayList<TreeNode> root = new ArrayList<>();
            root.add(node);
            return root;
        }
        ArrayList<TreeNode> l = nodeToRootPath(node.left, data);
        if (l.size() > 0) {
            l.add(node);
            return l;
        }
        ArrayList<TreeNode> r = nodeToRootPath(node.right, data);
        if (r.size() > 0) {
            r.add(node);
            return r;
        }
        return new ArrayList<>();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode data, int k) {
        ArrayList<TreeNode> ans = nodeToRootPath(root, data.val);
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            printKLevelsDown(ans.get(i), k - i, i == 0 ? null : ans.get(i - 1), a);
        }
        return a;
    }
}
