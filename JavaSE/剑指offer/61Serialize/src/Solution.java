class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;

    }

}


public class Solution {

    // 实现二叉树的序列化和反序列化

    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
            return root.val + "," + Serialize (root.left) + "," + Serialize (root.right);
        }
    }


    // 根据字符串重新构造二叉树

    int index = 0;
    TreeNode Deserialize(String str) {
        String[] arr = str.split (",");
        index++;
        if(index > arr.length){
            return null;
        }
        TreeNode node = null;
        if(!arr[index].equals ("#")){
            node = new TreeNode (Integer.parseInt (arr[index]));
            node.left = Deserialize (str);
            node.right = Deserialize (str);
        }
        return node;
    }
}