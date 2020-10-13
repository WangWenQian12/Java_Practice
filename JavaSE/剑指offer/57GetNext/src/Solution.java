import java.util.ArrayList;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 指向父结点

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // 二叉树的下一个结点
    // 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

    static ArrayList<TreeLinkNode> list = new ArrayList<> ();

    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        TreeLinkNode cur = pNode;
        // 根据指向父结点的指针找到根结点
        while(cur.next != null){
            cur = cur.next;
        }
        // 得到中序遍历序列
        InOrder(cur);
        for(int i = 0;i < list.size ();i++){
            if(pNode == list.get (i)){
                if(i == list.size () - 1){
                    return null;
                }else{
                    return list.get (i+1);
                }
            }
        }
        return null;
    }

    private static void InOrder(TreeLinkNode cur) {
        if(cur != null){
            InOrder (cur.left);
            list.add (cur);
            InOrder (cur.right);
        }
    }

    public static void main(String[] args) {

    }
}