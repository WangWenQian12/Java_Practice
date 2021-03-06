class TreeNode {
    int val = 0;
    TreeNode left = null;
     TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
 }


public class Solution {

    // 二叉树的深度

    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth (root.left);
        int right = TreeDepth (root.right);

        return Math.max (left,right) + 1;
    }
}