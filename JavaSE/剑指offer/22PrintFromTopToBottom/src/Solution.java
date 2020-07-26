import java.util.ArrayList;
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

    // 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    // 二叉树的层序遍历
    //（1）根结点入队列
    //（2）当队列不为空时，根结点出队列，并将其值存入 list
    //（3）如果此时的结点有左右孩子，则分别将左右孩子入队列

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<> ();

        if(root == null){
            return list;
        }

        queue.offer (root);
        TreeNode cur = root;
        while(!queue.isEmpty ()){
            TreeNode front = queue.poll ();
            list.add (front.val);
            if(front.left != null){
                queue.offer (front.left);
            }
            if(front.right != null){
                queue.offer (front.right);
            }
        }
        return list;
    }
}