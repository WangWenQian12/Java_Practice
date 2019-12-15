public class TravelsalBinaryTree {

    //二叉树的三种遍历方式

    //创建一个内部类(当前class下可以访问)
    private static class Node{
        int val;
        Node left;
        Node right;
        Node parents;
        private Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("[%c]",val);
        }
    }

    //创建一颗二叉树
    private static Node buildBinaryTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left= b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

        return a;
    }

    //前序遍历二叉树
    public static void preOrderTravelsal(Node root){
        if(root == null){
            return;
        }

        //根 + 左子树的前序遍历 + 右子树的前序遍历
        System.out.println (root);
        preOrderTravelsal (root.left);
        preOrderTravelsal (root.right);
    }

    //中序遍历二叉树
    public static void inOrderTravelsal(Node root){
        if(root == null){
            return;
        }

        //左子树的中序遍历 + 根 + 右子树的中序遍历
        inOrderTravelsal (root.left);
        System.out.println (root);
        inOrderTravelsal (root.right);
    }

    //后序遍历二叉树
    public static void postOrderTravelsal(Node root){
        if(root == null){
            return;
        }

        //左子树的后序遍历 + 右子树的后序遍历 + 根
        postOrderTravelsal (root.left);
        postOrderTravelsal (root.right);
        System.out.println (root);
    }

    public static void main(String[] args) {
        Node root = buildBinaryTree();

        //前序遍历
        preOrderTravelsal (root);// A B D E H C F G
        System.out.println ("============================");

        //中序遍历
        inOrderTravelsal (root);//D B E H A F C G
        System.out.println ("============================");

        //后序遍历
        postOrderTravelsal (root);//D H E B F G C A

    }
}
