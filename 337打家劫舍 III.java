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
    Map<TreeNode,Integer> memo=new HashMap<>();

    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(memo.containsKey(root))
            return memo.get(root);
        int robThis=root.val+(root.left==null?0:rob(root.left.left)+rob(root.left.right))+(root.right==null?0:rob(root.right.left)+rob(root.right.right));
        int notRobThis=rob(root.left)+rob(root.right);
        int res=Math.max(robThis,notRobThis);
        memo.put(root,res);
        return res;
    }
}