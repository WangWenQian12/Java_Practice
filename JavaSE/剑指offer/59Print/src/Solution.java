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

    // 按之字形顺序打印二叉树
    // 利用队列

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<> ();
        if(pRoot == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (pRoot);
        // true就从左到右遍历，false就从右到左遍历
        boolean flag = true;
        while(!queue.isEmpty ()){
            ArrayList<Integer> list = new ArrayList<> ();
            int size = queue.size ();
            for(int i = 0;i < size;i++) {
                TreeNode node = queue.poll ();
                if(node == null){
                    continue;
                }
                if(flag){
                    list.add (node.val);
                }else{
                    list.add (0,node.val); // 逆序放置
                }
                queue.offer (node.left);
                queue.offer (node.right);
            }
            flag = !flag;
            if(list.size () > 0){
                res.add (list);
            }
        }
        return res;
    }
}