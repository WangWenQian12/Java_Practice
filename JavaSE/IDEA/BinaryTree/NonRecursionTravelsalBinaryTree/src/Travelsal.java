import java.security.PublicKey;
import java.util.Stack;

public class Travelsal {

    //二叉树的三种非递归遍历
 
    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
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


    //非递归前序遍历
    public static void prevorder(Node root){
        Stack<Node> stack = new Stack<> ();

        Node cur = root;
        while (cur != null || !stack.isEmpty ()){
            while(cur != null){
                System.out.println (cur);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    }

    //非递归中序遍历
    public static void inorder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty ()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println (top);
            cur = top.right;
        }
    }

    //非递归后序遍历
    public static void postorder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;//记录已经被打印过的结点
        while(cur != null || !stack.isEmpty ()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if(top.right == null || top.right == last){
                System.out.println (top);
                stack.pop();//先遍历之后再出栈
                last = top;//此结点已经打印，将此结点记录
            }else{
                cur = top.right;
            }
        }
    }





    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        prevorder (root);
        System.out.println ();

        inorder (root);
        System.out.println ();

        postorder (root);
    }
}
