import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class test {

    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format ("{%c}",val);
        }
    }

    //构建一颗二叉树
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

    //层序遍历
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<> ();
        queue.offer(root);
        if(!(queue.isEmpty ())){
            Node front = queue.poll();//出队列
            System.out.println (front);
            if(front.left != null){
                queue.offer(front.left);
            }
            if(front.right != null){
                queue.offer(front.right);
            }
        }

    }

    //二叉树前中后序的非递归遍历
    public static void preorder(Node root) {
        Stack<Node> stack = new Stack<> ();
        Node cur = root;
        while(cur != null || !stack.isEmpty ()) {
            while (cur != null) {
                System.out.println (cur);
                stack.push (cur);
                cur = cur.left;
            }
            Node top = stack.pop ();
            cur = top.right;
        }

    }

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

    public static void postorder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;
        while(cur != null || !stack.isEmpty ()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if(top.right == null || top.right == last){//用last记录上一个被打印的结点，用来区分是否被遍历过
                System.out.println (top);
                stack.pop();
                last = top;
            }else{
                cur = top.right;
            }
        }
    }

    //返回值为List的非递归遍历二叉树
    public static List<Integer> preOrder(Node root){
        List<Integer> list = new LinkedList<>();
        if(root == null){
            return list;
        }
        Node cur = root;
        Stack<Node> stack = new Stack<> ();
        while(cur != null || !stack.isEmpty ()){
            while(cur != null) {
                list.add(cur.val);
                stack.push (cur);
                cur = cur.left;
            }
        }
        Node top = stack.pop();
        top = cur.right;

        return list;
    }


    public static List<Integer> inOrder(Node root){
        List<Integer> list = new LinkedList<> ();

        Stack<Node> stack = new Stack<>();
        Node cur = root;

        while(cur != null || !stack.isEmpty ()){
            while(cur != null) {
                stack.push (cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            list.add(top.val);
            cur = top.right;
        }
        return list;

    }

    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        preorder (root);
        System.out.println ();
        inorder (root);
        System.out.println ();
        postorder (root);

    }
}
