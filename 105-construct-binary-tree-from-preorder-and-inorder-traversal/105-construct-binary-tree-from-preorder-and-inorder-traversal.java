class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {  
          map.put(inorder[i],i);
        }
        return help(preorder,inorder,0,inorder.length-1,0,preorder.length-1,map);
    }
    public TreeNode help(int[] preorder, int[] inorder,int prl,int prh,int inl,int inh,HashMap<Integer,Integer>map) {
        if(prl>prh || inl>inh)return null;
        TreeNode node=new TreeNode(preorder[prl]);
        int idx=map.get(preorder[prl]);
        int lhs=map.get(preorder[prl])-inl;
        node.left=help(preorder,inorder,prl+1,prl+lhs,inl,idx-1,map);
        node.right=help(preorder,inorder,prl+lhs+1,prh,idx+1,inh,map);
        return node;
    }
}
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         for(int i=0;i<inorder.length;i++)
//         {
//             map.put(inorder[i],i);
            
//         }
//         return contruct(0,preorder.length-1,0,inorder.length-1,inorder,preorder,map);
//     }
//     public TreeNode contruct(int pl,int ph,int il,int ih,int[]inorder,int []preorder,HashMap<Integer,Integer>map) {
//         if(pl>ph || il>ih)return null;
//         TreeNode node=new TreeNode();
//         node.val=preorder[pl];
//         int idx=map.get(preorder[pl]);
//         int lhs=map.get(preorder[pl])-il;
//         node.left=contruct(pl+1,pl+lhs,il,idx-1,inorder,preorder,map);
//         node.right=contruct(pl+lhs+1,ph,idx+1,ih,inorder,preorder,map);
//         return node;
//     }
// }