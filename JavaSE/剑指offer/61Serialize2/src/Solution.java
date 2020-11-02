import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
 
public class Solution {

    // 请实现两个函数，分别用来序列化和反序列化二叉树

    // 序列化
    public static String Serialize(TreeNode root) {
        StringBuilder res = new StringBuilder ("");
        if(root == null) {
            return res.toString ();
        }
        res.append (root.val);
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (root);
        while (!queue.isEmpty ()) {
            TreeNode node = queue.poll ();
            if (node.left != null || node.right != null) {
                if (node.left == null) {
                    res.append (",#");
                } else {
                    res.append ("," + String.valueOf (node.left.val));
                    queue.offer (node.left);
                }
                if (node.right == null) {
                    res.append (",#");
                } else {
                    res.append ("," + String.valueOf (node.right.val));
                    queue.offer (node.right);
                }
            } else {
                // 叶子结点不需要处理
            }
        }

        return res.toString ();
    }

    // 反序列化
    public static TreeNode Deserialize(String str) {
        TreeNode root = null;
        if (str.equals ("")) {
            return root;
        }
        String[] arr = str.split (",");
        root = new TreeNode (Integer.parseInt (arr[0]));

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (root);
        int index = 1;
        while (!queue.isEmpty () && index < arr.length) {
            // 当前子树父结点
            TreeNode tmp = queue.poll ();
            if (index < arr.length && !arr[index].equals ("#")) {
                TreeNode left = new TreeNode (Integer.parseInt (arr[index]));
                tmp.left = left;
                index++;
                queue.offer (left);
            } else {
                index++;
            }
            if (index < arr.length && !arr[index].equals ("#")) {
                TreeNode right = new TreeNode (Integer.parseInt (arr[index]));
                tmp.right = right;
                index++;
                queue.offer (right);
            } else {
                index++;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = Deserialize("5,4,#,3,#,2");
        System.out.println (Serialize (root));
    }
}
