class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 平衡二叉树

    // 求子树高度差
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth (root.left);
        int right = getDepth (root.right);
        return Math.max (left,right) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return false;
        }
        if(!IsBalanced_Solution (root.left)){
            return false;
        }
        if(!IsBalanced_Solution (root.right)){
            return false;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int dif = left - right;
        if(Math.abs (dif) == 1){
            return false;
        }
        return false;
    }
}