import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    // 根据前序遍历和中序遍历推导二叉树
    // 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length == 0) {
            return null;
        }

        int v = pre[0]; // 前序遍历数组的首元素，即当前子树的根节点
        int count = -1;
        for (int i = 0; i < in.length; i++) {
            if (v == in[i]) {
                count = i; // 在中序遍历数组中找到根节点，用于后续分隔数组
            }
        }

        TreeNode root = new TreeNode (v); // 构造根节点

        // 左闭右开
        int[] leftpre = Arrays.copyOfRange (pre, 1, count + 1);
        int[] leftin = Arrays.copyOfRange (in, 0, count);
        root.left = reConstructBinaryTree (leftpre, leftin);

        int[] rightpre = Arrays.copyOfRange (pre, count + 1, pre.length);
        int[] rightin = Arrays.copyOfRange (in, count + 1, in.length);
        root.right = reConstructBinaryTree (rightpre, rightin);

        return root;

    }

    public static void main(String[] args) {
        int[] pre = {3,6,4,2,5,8,1,7,9};
        int[] in = {4,6,5,2,3,1,8,7,9};
        System.out.println (reConstructBinaryTree (pre,in));
    }
}