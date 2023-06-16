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
    TreeNode getMinNode(TreeNode root){
        while(root.left!=null)
            root=root.left;
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val==key){
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            TreeNode min=getMinNode(root.right);
            root.right=deleteNode(root.right,min.val);
            min.right=root.right;
            min.left=root.left;
            root=min;
        }else if(root.val<key)
            root.right=deleteNode(root.right,key);
        else if(root.val>key)
            root.left= deleteNode(root.left,key);
        return root;
    }
}