import java.util.HashMap;

class ListNode {
    int val = 0;
    ListNode left = null;
    ListNode right = null;

    public ListNode(int val) {
        this.val = val;
    }
 }

public class Solution {

    // 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    // 递归

    public static boolean isSameTree(ListNode root1,ListNode root2){

        // 判断是否为相同的两棵树

        // root2为空，则说明root2已经遍历完成，返回true
        if(root2 == null){
            return true;
        }
        // root1为空，则说明root1已经遍历结束，但是没有找到，返回false
        if(root1 == null){
            return false;
        }

        return root1.val == root2.val
                && isSameTree (root1.left,root2.left)
                && isSameTree (root1.right,root2.right);
    }

    public static boolean HasSubtree(ListNode root1,ListNode root2) {

        if(root1 == null || root2 == null){
            return false;
        }

        // 结点相等时，调用函数判断左右子树是否相等
        if(root1.val == root2.val){
            if(isSameTree (root1,root2)){
                return true;
            }
        }

        return HasSubtree (root1.left,root2) || HasSubtree (root1.right,root2);
    }
}