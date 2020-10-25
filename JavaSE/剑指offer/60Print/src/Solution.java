import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    // 把二叉树打印成多行

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<> ();

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (pRoot);
        while(!queue.isEmpty ()){
            ArrayList<Integer> list = new ArrayList<> ();
            int size = queue.size ();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll ();
                if(node == null){
                    continue;
                }
                list.add (node.val);
                queue.offer (node.left);
                queue.offer (node.right);
            }
            if(list.size () > 0){
                res.add (list);
            }
        }
        return res;
    }

}