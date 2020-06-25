import java.util.LinkedList;
import java.util.Queue;

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
    // 非递归：利用队列

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (root);
        TreeNode cur = null;
        TreeNode tmp = null;
        while(!queue.isEmpty ()){
            for(int i = 0; i < queue.size ();i++){
                cur = queue.poll ();// 队首元素出列
                tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if(cur.left != null){
                    queue.offer (cur.left);
                }
                if(cur.right != null){
                    queue.offer (cur.right);
                }
            }
        }
    }
}