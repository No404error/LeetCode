/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SEP=",";
    private static final String NIL="#";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NIL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes=new LinkedList<>();
        for(String s:data.split(SEP))
            nodes.addLast(s);
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty())
            return null;
        String node=nodes.removeFirst();
        if(node.equals(NIL))
            return null;
        TreeNode root=new TreeNode(Integer.parseInt(node));
        root.left=deserialize(nodes);
        root.right=deserialize(nodes);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));