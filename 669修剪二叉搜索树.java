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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)
            return null;
        int val=root.val;
        if(val<low)
            root=trimBST(root.right,low,high);
        else if(val==low){
            root.left=null;
            root.right=trimBST(root.right,low,high);
        }else if(val>high)
            root=trimBST(root.left,low,high);
        else if(val==high){
            root.right=null;
            root.left=trimBST(root.left,low,high);
        }else{
            root.right=trimBST(root.right,low,high);
            root.left=trimBST(root.left,low,high);
        }
        return root;
    }