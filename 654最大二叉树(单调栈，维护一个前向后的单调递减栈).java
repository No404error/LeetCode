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
    TreeNode[] stk=new TreeNode[1010];

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int head=0,tail=0;
        for(int x:nums){
            TreeNode node=new TreeNode(x);
            while(head<tail&&stk[tail-1].val<x) node.left=stk[--tail];
            if(head<tail)
                stk[tail-1].right=node;
            stk[tail++]=node;
        }
        return stk[0];
    }
}