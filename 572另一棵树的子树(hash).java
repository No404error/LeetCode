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

    static final int maxn = 1005;
    static final int mod = 1000000007;
    boolean[] vis=new boolean[maxn];
    int[] prime=new int[maxn];
    int tot=0;

    public void getPrime(){
        for(int i=2;i<maxn;i++){
            if(!vis[i]){
                prime[++tot]=i;
                for(int j=2*i;j<maxn;j+=i)
                    vis[j]=true;
            }
        }
    }

    Map<TreeNode, int[]> hS = new HashMap<TreeNode, int[]>();
    Map<TreeNode, int[]> hT = new HashMap<TreeNode, int[]>();

    void dfs(TreeNode root,Map<TreeNode,int[]> h){
        h.put(root,new int[]{root.val,1});
        int[] val=h.get(root);
        if(root.left==null&&root.right==null)
            return;
        if(root.left!=null){
            dfs(root.left,h);
            int val1[]=h.get(root.left);
            val[1]+=val1[1];
            val[0]=(int)((val[0]+(31L*val1[0]*prime[val1[1]])%mod)%mod);
        }

        if(root.right!=null){
            dfs(root.right,h);
            int val1[]=h.get(root.right);
            val[1]+=val1[1];
            val[0]=(int)((val[0]+(179L*val1[0]*prime[val1[1]])%mod)%mod);
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        getPrime();
        dfs(root,hT);
        dfs(subRoot,hS);
        int sHash=hS.get(subRoot)[0];
        for (Map.Entry<TreeNode, int[]> entry : hT.entrySet()) {
            if (entry.getValue()[0] == sHash) {
                return true;
            }
        }
        return false;
    }
}