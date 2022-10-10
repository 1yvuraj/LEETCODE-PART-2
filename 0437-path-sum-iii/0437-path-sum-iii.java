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
// class Solution {
//     int ans = 0;

//     public int pathSum(TreeNode root, int targetSum) {
//         ans = 0;
//         help(root, targetSum);
//         return ans;
//     }

//     public void help1(TreeNode root, int targetSum) {
//         if (root == null) return;
//         if (targetSum == root.val) ans++;
//         help1(root.left, targetSum - root.val);
//         help1(root.right, targetSum - root.val);
//     }

//     public void help(TreeNode root, int targetSum) {
//         if (root == null) return;
//         help1(root, targetSum);
//         help(root.left, targetSum);
//         help(root.right, targetSum);
//     }
// }
class Solution {
int count = 0;
public int pathSum(TreeNode root, int targetSum) {

    countTarget_temp(root , targetSum);
    return count;
}
public void countTarget_temp(TreeNode node , int targetSum){
    if(node == null){
        return;
    }
    //if(node.val == -2)
    countTarget(node , 0 , targetSum);
    
    countTarget_temp(node.left , targetSum);
    countTarget_temp(node.right , targetSum);
}

public void countTarget(TreeNode node , long csum , int targetSum){
    if(node == null){

        return;
    }
    //System.out.println(node.val + " " + csum);
    if(csum+node.val == targetSum){
        //System.out.println(csum  + " " + node.val);
        count++;
    }
    countTarget(node.left , csum+node.val , targetSum);
    countTarget(node.right , csum+node.val , targetSum);
}
}
