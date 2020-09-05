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

    // 二叉树的深度
    // 利用队列
    // 判别队列中某一层节点出队完成的标准是什么？
    // 在出队之前，此时队列中记录的只有某一层节点，所以队列的大小就是某一层节点的个数。当此个数减到0的时候，则说明该层节点全部出队完成

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        queue.add (root);

        int depth = 0;
        // 用size控制depth增长的次数和时机(同一层的元素没有完全退出队列的时候high不可以增加)
        int size = -1;
        while (!queue.isEmpty()) {
            size = queue.size ();
            while (size != 0) {
                TreeNode node = queue.poll ();
                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}