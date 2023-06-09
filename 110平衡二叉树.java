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

    boolean ok=true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ok;
    }

    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int l=dfs(root.left);
        int r=dfs(root.right);
        if(ok){
            if(Math.abs(l-r)<=1)
                return Math.max(l,r)+1;
            else{
                ok=false;
                return -1;
            }
        }else
            return -1;
    }
}