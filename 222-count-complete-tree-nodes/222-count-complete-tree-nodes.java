class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode ln = root.left;
        int lnc = 1;
        while (ln != null) {
            ln = ln.left;
            lnc++;
        }
        TreeNode rn = root.right;
        int rnc = 1;
        while (rn != null) {
            rn = rn.right;
            rnc++;
        }
        if (rnc == lnc) return (int)(Math.pow(2, rnc))-1; 
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
