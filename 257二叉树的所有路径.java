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
    List<String> ans=null;

    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        dfs(root,new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root,StringBuilder cur){
        if(root==null){
            return; 
        }
        if(root.left==null&&root.right==null){
            ans.add(cur.toString()+root.val);
            return;
        }
        int sz=cur.length();
        cur.append(root.val+"->");
        dfs(root.left,cur);
        dfs(root.right,cur);
        cur.setLength(sz);
    }
}