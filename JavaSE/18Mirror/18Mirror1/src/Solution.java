class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
 }

public class Solution {

    // 操作给定的二叉树，将其变换为源二叉树的镜像。
    // 递归：交换左右节点

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror (root.left);
        Mirror (root.right);
    }
}