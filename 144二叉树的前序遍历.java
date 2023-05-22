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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root!=null) traverse(list,root);
        return list;
    }
    public void traverse(List<Integer> list,TreeNode root){
        list.add(root.val);
        if(root.left!=null) traverse(list,root.left);
        if(root.right!=null) traverse(list,root.right);
    }
}