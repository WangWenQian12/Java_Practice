import sun.reflect.generics.tree.Tree;

class TreeNode {
    char val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(char val) {
        this.val = val;
    }

    public String toString(){
        return String.format ("%c",val);
    }
}

public class Main {

    //判断是否为平衡二叉树
    //先用递归求出左右子树的高度
    //用高度差判断是否为平衡二叉树


    public static boolean isBalance(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!(isBalance (root.left))){
            return false;
        }
        if(!(isBalance (root.right))){
            return false;
        }

        int left = getLength(root.left);
        int right = getLength(root.right);
        int dif = left-right;
        if(dif <= 1 && dif >= -1){
            return true;
        }
        return false;

    }

    public static int getLength(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getLength (root.left);
        int right = getLength (root.right);
        return Math.max (left,right) + 1;
    }

    }
}
