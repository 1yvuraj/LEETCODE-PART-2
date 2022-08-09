
class Solution {
    
    public class pair{
            int ht=-1;
            int dia=0;
            
            pair(int ht,int dia){
                this.ht = ht;
                this.dia = dia;
            }
    }
    
    public pair diameterOfBinaryTree_(TreeNode root){
        if(root==null){
            pair p = new pair(-1,0);
            
            return p;
        }
        
        pair lp = diameterOfBinaryTree_(root.left);
        pair rp = diameterOfBinaryTree_(root.right);
        
        pair mp = new pair(Math.max(lp.ht,rp.ht)+1,Math.max(lp.ht+rp.ht+2,Math.max(lp.dia,rp.dia)));
        
        
        return mp;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        pair ans = diameterOfBinaryTree_(root);
        return ans.dia;
    }
}