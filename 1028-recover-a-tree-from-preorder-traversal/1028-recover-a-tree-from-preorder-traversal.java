
class Solution {
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return help(traversal,0);
    }
    public TreeNode help(String str,int depth) {
        int d=0;
        while(i+d<str.length() && str.charAt(i+d)=='-')
        {
            d++;
        }
        if(d!=depth)
        {
            return null;
        }
        int nd=0;
        while(i+nd+d<str.length() && str.charAt(i+nd+d)!='-')
        {
            nd++;
        }
        int val=Integer.parseInt(str.substring(i+d,i+d+nd));
         i=i+d+nd;
        TreeNode node=new TreeNode(val);
        
        node.left=help(str,d+1);
        node.right=help(str,d+1);
        return node;
        
    }
}