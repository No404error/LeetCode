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
    List<Integer> res=new ArrayList<>();
    TreeNode prev=null;
    int curCount=0;
    int maxCount=0;

    public int[] findMode(TreeNode root) {
        traverse(root);
        int[] a=new int[res.size()];
        for(int i=0;i<res.size();i++)
            a[i]=res.get(i);
        return a;
    }

    void traverse(TreeNode root){
        if(root==null)
            return;
        traverse(root.left);
        if(prev==null){
            maxCount=curCount=1;
            res.add(root.val);
        }else if(prev.val==root.val){
            curCount++;
            if(curCount==maxCount)
                res.add(root.val);
            if(curCount>maxCount){
                maxCount=curCount;
                res.clear();
                res.add(root.val);
            }
        }else if(prev.val!=root.val){
            curCount=1;
            if(curCount==maxCount)
                res.add(root.val);
        }
        prev=root;
        traverse(root.right);
    }
}