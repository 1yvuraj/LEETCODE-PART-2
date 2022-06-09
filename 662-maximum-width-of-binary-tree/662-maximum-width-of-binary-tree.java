class Solution {
    int max=-(int)1e9;
    public class pair{
        int idx;
        TreeNode node;
        pair(int idx,TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        help(root);
        return max;
    }
    public void help(TreeNode root) {
        LinkedList<pair>list=new LinkedList<>();
        list.addLast(new pair(0,root));
        while(list.size()>0)
        {
            int size=list.size();
            int l=list.getFirst().idx;
            int r=list.getFirst().idx;
            while(size-->0)
            {
                pair p=list.removeFirst();
                r=p.idx;
                max=Math.max(max,r-l+1);
                if(p.node.left!=null)
                {
                    list.addLast(new pair(p.idx*2+1,p.node.left));
                }
                if(p.node.right!=null)
                {
                    list.addLast(new pair(p.idx*2+2,p.node.right));
                }
                
            }
        }
    }
}