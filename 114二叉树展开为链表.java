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
    public void flatten(TreeNode root) {
        flattenAndEnd(root);
    }

    TreeNode flattenAndEnd(TreeNode root){
        if(root==null)
            return null;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        TreeNode leftEnd=flattenAndEnd(left);
        TreeNode rightEnd=flattenAndEnd(right);
        if(rightEnd==null&&leftEnd==null)
            return root;
        else if(rightEnd==null){
            root.right=left;
            return leftEnd;
        }else if(leftEnd==null){
            root.right=right;
            return rightEnd;
        }else{
            root.right=left;
            leftEnd.right=right;
            return rightEnd;
        }
    }
}