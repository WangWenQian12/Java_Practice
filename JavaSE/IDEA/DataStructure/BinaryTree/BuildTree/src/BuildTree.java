import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

public class BuildTree {

    private static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%d}",val);
        }
    }


    //利用前序遍历和中序遍历还原二叉树
    public static Node buildTree(int[] preorder,int[] inorder){
        if(preorder.length == 0){
            return null;
        }

        //System.out.println (preorder[0]);
        int r = preorder[0];
        //System.out.println (preorder[0]);

        int leftCount = 0;
        for(int i=0;i<preorder.length-1;i++){
            if(preorder[i] == r){
                leftCount = i;//中序遍历的前leftCount个元素是左子树
                break;
            }
        }

        Node root = new Node(r);

        int[] leftprev = Arrays.copyOfRange (preorder,1,leftCount+1);
        int[] leftin = Arrays.copyOfRange (inorder,0,leftCount);
        root.left = buildTree(leftprev,leftin);

        int[] rightprev = Arrays.copyOfRange (preorder,leftCount+1,preorder.length);
        int[] rightin = Arrays.copyOfRange (inorder,leftCount+1,inorder.length);
        root.right = buildTree(rightprev,rightin);

        return root;
    }


    public static void main(String[] args) {
        int[] pre = {12,4,5,8,3,6,7};
        int[] in = {4,2,5,8,1,6,3,7};
        System.out.println (buildTree (pre,in));
    }
}
