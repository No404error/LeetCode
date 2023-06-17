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
    public TreeNode sortedArrayToBST(int[] nums) {
        arr=nums;
        return traverse(0,nums.length);
    }
    int[] arr;
    TreeNode traverse(int s,int e){
        if(s>=e)
            return null;
        int pos=(s+e)/2;
        TreeNode root=new TreeNode(arr[pos]);
        root.left=traverse(s,pos);
        root.right=traverse(pos+1,e);
        return root;
    }
}