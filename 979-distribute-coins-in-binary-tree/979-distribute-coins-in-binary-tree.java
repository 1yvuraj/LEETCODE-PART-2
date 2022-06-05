class Solution {
    int moves=0;
    public static class pair{
        int nodev;
        int nodec;
        pair(int nodev,int nodec)
        {
            this.nodev=nodev;
            this.nodec=nodec;
        }
    }
    public int distributeCoins(TreeNode root) {
        help(root);
        return  moves;
    }
    public pair help(TreeNode root) {
        if(root==null)
        {
            return new pair(0,0);
        }
        pair l=help(root.left);
        pair r=help(root.right);
        int nodec=l.nodec+r.nodec+1;
        int m=l.nodev+r.nodev+root.val;
        moves+=Math.abs(nodec-m);
        return new pair(m,nodec);
        
    }
}