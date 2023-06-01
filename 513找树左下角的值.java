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
    public int findBottomLeftValue(TreeNode root) {
        int res=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                TreeNode cur=q.poll();
                if(i==0)
                    res=cur.val;
                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }
        }
        return res;
    }
}