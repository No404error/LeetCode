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
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] pre,int s1,int e1,int[] ino,int s2,int e2){
        if(s1>e1)
            return null;

        TreeNode root=new TreeNode(pre[s1]);
        if(s1==e1)
            return root;
        else{
            int pos=map.get(pre[s1]);
            int leftSize=pos-s2;
            root.left=buildTree(pre,s1+1,s1+leftSize,ino,s2,pos-1);
            root.right=buildTree(pre,s1+leftSize+1,e1,ino,pos+1,e2);
            return root;
        }
    }
}