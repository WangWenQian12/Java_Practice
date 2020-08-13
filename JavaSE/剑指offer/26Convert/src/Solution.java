import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
 }

public class Solution {

    // 二叉搜索树与双向链表

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<> ();
        inOrderCovert(pRootOfTree,list);
        return resultCovert (list);

    }

    // 按中序遍历顺序，即二叉搜索树的大小顺序将各结点保存至 list
    public void inOrderCovert(TreeNode root,ArrayList<TreeNode> list){
        if(root.left != null){
            inOrderCovert (root.left,list);
        }
        list.add(root);
        if(root.right != null){
            inOrderCovert (root.right,list);
        }
    }

    // 遍历list，修改指针
    public TreeNode resultCovert(ArrayList<TreeNode> list){
        for(int i = 0;i < list.size ()-1;i++){
            list.get(i).right = list.get (i+1);
            list.get(i+1).left = list.get (i);
        }
        return list.get (0);
    }


}