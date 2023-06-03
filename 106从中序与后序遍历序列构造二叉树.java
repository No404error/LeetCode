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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    TreeNode buildTree(int[] ino,int is,int ie,int[] pos,int ps,int pe){
        if(is>ie)
            return null;
        TreeNode root=new TreeNode(pos[pe]);
        int rootPos=map.get(pos[pe]);
        int leftSize=rootPos-is;
        root.left=buildTree(ino,is,rootPos-1,pos,ps,ps+leftSize-1);
        root.right=buildTree(ino,rootPos+1,ie,pos,ps+leftSize,pe-1);
        return root;
    }
}