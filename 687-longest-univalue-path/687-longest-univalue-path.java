class Solution {
    int max=-(int)1e9;
    public class pair{
        int h;
        TreeNode v;
        pair(int h,TreeNode v)
        {
            this.h=h;
            this.v=v;
        }

    }
    public int longestUnivaluePath(TreeNode root) {
        max=-(int)1e9;
        help(root);
        return max==-(int)1e9?0:max-1;
    }
     public pair help(TreeNode root) {
         if(root==null)
         {
             return new pair(0,null);
         }
         pair l=help(root.left);
         pair r=help(root.right);
         int hl=0;
         int hr=0;
         
         if(l.v!=null && l.v.val==root.val)
         {
             hl=l.h;
             
         } 
         if(r.v!=null && r.v.val==root.val){
             hr=r.h;
            
         }
         
         max=Math.max(max,hl+hr+1);
         return new pair(Math.max(hr,hl)+1,root);

    }
}
// class Solution {
//     static class Pair {
//         TreeNode node_kya_tha;
//         int LCP_length;
        
//         Pair(TreeNode node_kya_tha, int LCP_length) {
//             this.node_kya_tha = node_kya_tha;
//             this.LCP_length = LCP_length;
//         }
//     }
    
//     static int ans =  Integer.MIN_VALUE;
    
//     public static Pair helper(TreeNode root) {
//         if(root ==  null){
//             return new Pair(null, 0);
//         }
        
//         Pair left_ans = helper(root.left);
//         Pair right_ans = helper(root.right);
        
//         int left_contri = 0;
//         int right_contri = 0;
        
//         if(left_ans.node_kya_tha != null && left_ans.node_kya_tha.val == root.val) {
//             left_contri = left_ans.LCP_length;
//         }
//         if(right_ans.node_kya_tha != null && right_ans.node_kya_tha.val == root.val) {
//             right_contri = right_ans.LCP_length;
//         }
        
//         ans = Math.max(ans, 1 + left_contri + right_contri);
        
//         Pair my_pair = new Pair(root, Math.max(left_contri, right_contri) + 1);
        
//         return my_pair;
//     }
//     public int longestUnivaluePath(TreeNode root) {
//          ans =  Integer.MIN_VALUE;
//         helper(root);
        
//         return ans == Integer.MIN_VALUE ? 0 : ans-1; //as # of edges has to be returned
//     }
// }