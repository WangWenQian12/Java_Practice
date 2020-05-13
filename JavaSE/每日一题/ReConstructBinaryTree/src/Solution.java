import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    // 根据前序遍历和中序遍历推导二叉树

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 ){
            return null;
        }

        int r = pre[0];
        int count = 0;
        for(int i = 0; i < in.length;i++){
            if(in[i] == r){
                count = i; // 找到根节点
                break;
            }
        }

        TreeNode root = new TreeNode(r); // 根节点

        int[] leftpre = Arrays.copyOfRange (pre,1,count+1);
        int[] leftin = Arrays.copyOfRange (in,0,count);
        root.left = reConstructBinaryTree (leftpre,leftin);

        int[] rightpre = Arrays.copyOfRange (pre,count+1,pre.length);
        int[] rightin = Arrays.copyOfRange (pre,count+1,in.length);
        root.right = reConstructBinaryTree (rightpre,rightin);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {12,4,5,8,3,6,7};
        int[] in = {4,2,5,8,1,6,3,7};
        System.out.println (reConstructBinaryTree (pre,in));
    }
}