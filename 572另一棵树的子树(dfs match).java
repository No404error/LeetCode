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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        else if(isSameTree(root,subRoot))
            return true;
        else if(isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot))
            return true;
        else
            return false;
    }

        public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null&&q==null)||(p!=null&&q!=null&&p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)))
            return true;
        else 
            return false;
    }
}