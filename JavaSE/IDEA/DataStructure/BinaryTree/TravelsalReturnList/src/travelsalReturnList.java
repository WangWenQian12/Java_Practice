import java.util.List;
import java.util.ArrayList;

public class travelsalReturnList {

    //写出返回值为List的二叉树的中序遍历

    private static class Node {
        private char val;
        private Node left = null;
        private Node right = null;

        private Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}", val);
        }
    }

    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }

    //前序遍历
    public static List<Character> preOrderTravelsal(Node root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        list.add(root.val);
        list.addAll(preOrderTravelsal (root.left));
        list.addAll(preOrderTravelsal (root.right));

        return list;

    }


    //中序遍历
    public static List<Character> inOrderTraversal(Node root) {
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        list.addAll(inOrderTraversal (root.left));
        list.add(root.val);
        list.addAll(inOrderTraversal (root.right));

        return list;
    }


    //后序遍历
    public static List<Character> postOrderTravelsal(Node root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        list.addAll(postOrderTravelsal (root.left));
        list.addAll(postOrderTravelsal (root.right));
        list.add(root.val);

        return list;
    }

    public static void main(String[] args) {
        Node root = buildTree ();

        System.out.println (preOrderTravelsal (root));//A B D E H C F G
        System.out.println (inOrderTraversal (root));//D B E H A F C G
        System.out.println (postOrderTravelsal (root));//D H E B F G C A
    }
}
