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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                int sz=q.size();
                List<Integer> level=new ArrayList<>();
                for(int i=0;i<sz;i++){
                    TreeNode cur=q.poll();
                    level.add(cur.val);
                    if(cur.left!=null)
                        q.offer(cur.left);
                    if(cur.right!=null)
                        q.offer(cur.right);
                }
                list.add(level);
            }
        }
        return list;
    }
}