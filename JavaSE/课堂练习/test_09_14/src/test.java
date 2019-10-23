import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/*class Node{
    int val;
    Node left;
    Node right;
    Node parent;
}*///外部类


    //Node root = null;//空树

public class test {

                                                  //二叉树

    //内部类
    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    //创建二叉树

    //前序遍历
    public static void preOrderTravelsal(Node root){
        if(root == null){
            return;
        }

        System.out.println (root);
        preOrderTravelsal(root.left);
        preOrderTravelsal(root.right);
    }


    //中序遍历
    public static void inOrderTravelsal(Node root){
        if(root == null){
            return;
        }

        inOrderTravelsal(root.left);
        System.out.println (root);
        inOrderTravelsal(root.right);
    }


    //遍历


    //汇总
    public static List<Character> inorderTravelsal(Node root){

        List<Character> list = new ArrayList<>();
        if(root == null){
           return  null;
        }

        List left = inorderTravelsal(root.left);
        List right = inorderTravelsal(root.right);


        list.addAll(left);
        //list.add();
        list.addAll(right);

        return list;

    }

    //后序遍历
    public static void postOrderTravelsal(Node root){
        if(root == null){
            return ;
        }

        postOrderTravelsal(root.left);
        postOrderTravelsal(root.right);
        System.out.println (root);
    }

    //求二叉树的结点个数
    //1.遍历
    private static int count = 0;
    public void getSize(Node root){
        if(root == null){
            return;
        }

        count++;
        getSize(root.left);
        getSize(root.right);
    }

    //2.汇总
    public static int getSize2(Node root){
        if(root == null){
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left+right+1;
    }


    //求叶子结点的个数



    //求二叉树的高度(汇总)
    public static int getHigh(Node root){
        if(root == null){
            return 0;
        }

        //取左子树和右子树高度的最大值
        int left = getHigh(root.left);
        int right = getHigh(root.right);

        return Math.max(left,right)+1;
    }

    //求二叉树第k层的结点个数


    //查找val所在结点的位置
    public static Node find(Node root,int val){
        if(root == null){
            return null;
        }

        if(val == root.val){
            return root;
        }

        Node n = find(root.left,val);
        if( n != null){
            return n;
        }

        Node m = find(root.right,val);
        if(m != null){
            return m;
        }
        return null;
    }

    //判断val是否在树里
    public static boolean find1(Node root,int val){
        if(root == null){
            return false;
        }

        if(val == root.val){
            return true;
        }

        if(find1(root.left,val)){
            return true;
        }

        return find1(root.right,val);
    }


    //判断是否为完全相等的二叉树
    public static boolean isSameTree(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val ==q.val
                && isSameTree(p.left,q.left)
                &&isSameTree(p.right,q.right);
    }

    //判断俩颗是否互为镜像的树
    public static boolean isMirrorTree(Node p,Node q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val
                && isMirrorTree (p.left,q.right)
                && isMirrorTree (p.right,q.left);
    }

    //判断一棵树是否为对称二叉树
    public static boolean isSymmetric(Node root){
        if(root == null){
            return false;
        }
        return isMirrorTree (root.left,root.right);
    }

    //给出俩个树，判断第二棵树是否为第一个树的子树
    public boolean search(Node root,Node t){
        if(root == null){
            return false;
        }

        if(isSameTree (root,t)){
            return true;
        }

        if(search(root.left,t)){
            return true;
        }

        return search(root.right,t);
    }


    public boolean isSubtree(Node s,Node t){
        return search (s,t);
    }


    //判断是否为平衡二叉树
    public static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        if(!(isBalanced (root.left))){
            return false;
        }
        if(!(isBalanced (root.right))){
            return false;
        }

        int left = getHigh(root.left);
        int right = getHigh (root.right);
        int diff = left-right;
        if(diff >= -1 && diff <= 1){
            return true;
        }
        return false;
    }

    //多次压栈出栈，效率低，可以一次返回多个值，只压栈出栈一次
    public static void main(String[] args) {

    }
}
