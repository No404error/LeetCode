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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return leftAndRight(root.left,root.right);
    }

    private boolean leftAndRight(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        else if(left!=null&&right!=null&&left.val==right.val){
            return leftAndRight(left.left,right.right)&&leftAndRight(left.right,right.left);
        }else 
            return false;
    }
}