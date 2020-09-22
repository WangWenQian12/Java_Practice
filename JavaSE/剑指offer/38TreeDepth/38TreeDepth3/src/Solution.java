import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

     public TreeNode(int val) {
        this.val = val;

    }

 }


public class Solution{

    // 二叉树的深度（层序遍历）


    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<TreeNode> list = new ArrayList<TreeNode> ();
        list.add (root);
        int depth = 0;

        while (list.size () != 0) {
            depth++;
            ArrayList<TreeNode> tmp = new ArrayList<> ();
            for (int i = 0; i < list.size (); i++) {
                while (list.get (i).left != null) {
                    tmp.add (list.get (i).left);
                }
                while (list.get (i).right != null) {
                    tmp.add (list.get (i).right);
                }
            }
            // list中存着一层结点
            list = tmp;
        }
        return depth;
    }
}