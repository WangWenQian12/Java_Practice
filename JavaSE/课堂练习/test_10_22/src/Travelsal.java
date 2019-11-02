import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}

public class Travelsal {

    //非递归后序遍历二叉树
    public void postOrderSal(TreeNode root){
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty ()){
            while(cur != null) {
                stack.push (cur);
                cur = cur.left;
            }


        }
        System.out.println (cur.val);

    }
}
