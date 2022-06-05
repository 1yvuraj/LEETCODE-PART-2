class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(postorder, inorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public TreeNode help(int[] postorder, int[] inorder, int prl, int prh, int inl, int inh, HashMap<Integer, Integer> map) {
        if (prl > prh || inl > inh) return null;
        TreeNode node = new TreeNode(postorder[prh]);
        int idx = map.get(postorder[prh]);
        int lhs = map.get(postorder[prh]) - inl;
        node.left = help(postorder, inorder, prl, prl+lhs-1, inl, idx - 1, map);
        node.right = help(postorder, inorder, prl+lhs, prh-1, idx + 1, inh, map);
        return node;
    }
}

