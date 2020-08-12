import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }


    public class Solution {

        // 二叉树中和为某一值的路径

        private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        private Stack<Integer> path = new Stack<> ();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null) {
                return result;
            }
            path.push (root.val);
            target -= root.val;

            if (target == 0 && root.left == null && root.right == null) {
                result.add (new ArrayList<Integer> (path));
            }

            FindPath (root.left, target);
            FindPath (root.right, target);

            path.pop ();
            return result;

        }
    }
}