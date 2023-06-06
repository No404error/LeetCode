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
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    int res=Integer.MAX_VALUE;
    TreeNode prev=null;
    void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        if(prev!=null)
            res=Math.min(res,root.val-prev.val);
        prev=root;
        dfs(root.right);
    }
}