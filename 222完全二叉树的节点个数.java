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

//完全二叉树可以分成一个满二叉树加一个完全二叉树或两个完全二叉树

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        TreeNode left=root,right=root;
        int lH=0,rH=0;
        while(left!=null){
            left=left.left;
            lH++;
        }
        while(right!=null){
            right=right.right;
            rH++;
        }
        if(lH==rH){
            return (int)Math.pow(2,lH)-1;
        }else
            return 1+countNodes(root.left)+countNodes(root.right);
    }
}