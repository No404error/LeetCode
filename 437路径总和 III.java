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
    public int pathSum(TreeNode root, int targetSum) {
        target=targetSum;
        map=new HashMap<>();
        map.put(0L,1);
        return dfsPathSum(root,0L);
    }

    int target;
    Map<Long,Integer> map;

    private int dfsPathSum(TreeNode root,Long sum){
        if(root==null)
            return 0;
        int res=0;
        sum+=root.val;
        res+=map.getOrDefault(sum-target,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        res+=dfsPathSum(root.left,sum);
        res+=dfsPathSum(root.right,sum);
        map.put(sum,map.get(sum)-1);
        return res;
    }
}