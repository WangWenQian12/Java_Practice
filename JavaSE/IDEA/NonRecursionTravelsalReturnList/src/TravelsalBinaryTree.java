import java.util.*;

public class TravelsalBinaryTree {

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


    //前序遍历
    public static List<Node> preorder(Node root){
        List<Node> list = new LinkedList<> ();
        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while(cur != null || !stack.isEmpty ()){
            while(cur != null){
                list.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
        return list;
    }

    //中序遍历
    public static List<Node> inorder(Node root){
        List<Node> list = new LinkedList<>();
        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<> ();
        Node cur = root;
        while(cur != null || !stack.isEmpty ()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            list.add(top);
            cur = top.right;
        }
        return list;
    }


    public static void main(String[] args) {
        Node root = buildBinaryTree ();

        System.out.println (preorder (root));

        System.out.println (inorder (root));
    }
}
