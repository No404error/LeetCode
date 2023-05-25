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
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root,1);
        return list;
    }

    int maxDepth=0;
    List<Integer> list=new ArrayList<>();
    public void traverse(TreeNode root,int depth){
        if(root==null)
            return;
        if(maxDepth<depth){
            maxDepth=depth;
            list.add(root.val);
        }
        traverse(root.right,depth+1);
        traverse(root.left,depth+1);
    }
}