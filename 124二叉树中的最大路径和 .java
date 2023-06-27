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
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
    int res=(int)-10e9;
    int maxPath(TreeNode root){
        if(root==null)
            return 0;
        int left=maxPath(root.left);
        int right=maxPath(root.right);
        int nowPathSum=root.val+Math.max(0,left)+Math.max(0,right);
        res=Math.max(res,nowPathSum);
        return root.val+Math.max(0,Math.max(left,right));
    }
}