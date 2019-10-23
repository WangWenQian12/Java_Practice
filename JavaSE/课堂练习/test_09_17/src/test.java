import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class test { 


    public static class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val){
            this.val = val;
        }
    }

    public List<Integer> postOrderTravelsal(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        list.addAll(postOrderTravelsal (root.left));
        list.addAll(postOrderTravelsal (root.right));
        list.add(root.val);

        return list;

    }


    //判断p和q是否为相等的俩颗树
    public static boolean isSameTree(Node p,Node q){
        if(p == null && q ==null){
            return true;
        }
        if(p == null || q ==null){
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }


    //在s这棵树中查找是否有和t相等的树
    public static boolean isSubTree(Node s,Node t){
        if(s == null){
            return false;
        }

        //先看根所在的树是否和t相同
        if(isSameTree(s,t)){
            return true;
        }
        //左子树中查找
        if(isSameTree (s.left,t)){
            return true;
        }
        //右子树中查找
        return isSameTree (s.right,t);

    }

    //交换一次的先行排列
    public static int[] prevPermOpt(int[] arr){
        for(int i=arr.length-2;i>0;i--){
            if(arr[i]>arr[i+1]) {
                int max = Integer.MIN_VALUE;
                int maxIndex = i + 1;
                for (int j = maxIndex; j < arr.length; j++) {
                    if (arr[j] < arr[i] && arr[j] > max) {
                        max = arr[j];
                        maxIndex = j;
                    }
                }

                int tmp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;



    }

    public static boolean search(Node r,Node t){
        if(r == null){
            return false;
        }

        //传进去的是一个结点
        if(r == t){
            return true;
        }

        if(search(r.left,t)){
            return true;
        }

        return search(r.right,t);
    }

    //查找俩个结点的最近祖先（有问题）
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(p == root || q == root){
            return root;
        }
        if(search(root.left,p) == search(root.left,q)){
            return lowestCommonAncestor (root.left,p,q);
        }
        if(search(root.right,p) == search(root.right,q)){
            return lowestCommonAncestor (root.right,p,q) ;
        }

        return root;

    }

    //从前序与中序遍历序列构造二叉树

    //从中序和后序遍历序列构造二叉树
    public static Node buildTree(int[] postorder,int[] inorder){
        if(postorder.length == 0){
            return null;
        }

        int rootValue = postorder[postorder.length-1];
        //找到中序遍历中根的位置
        int leftCount = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] ==rootValue ){
                leftCount = i;
            }
        }

        Node root = new Node(rootValue);

        //拆数组
        int[] leftPostOrder = Arrays.copyOfRange (postorder,0,leftCount);
        int[] leftInOrder = Arrays.copyOfRange (inorder,0,leftCount);
        root.left = buildTree(leftPostOrder,leftInOrder);
        
        int[] rightPostOrder = Arrays.copyOfRange (postorder,leftCount,postorder.length-1);
        int[] rightInOrder = Arrays.copyOfRange (postorder,leftCount+1,inorder.length);
        root.right = buildTree(rightPostOrder,rightInOrder);

        return root;

    }


    public static void main(String[] args) {


    }
}
