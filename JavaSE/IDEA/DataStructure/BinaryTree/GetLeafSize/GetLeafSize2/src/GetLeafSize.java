public class GetLeafSize {

    //求二叉树的叶子结点的个数

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

    //遍历的思路

    public static int count = 0;
    public static void getLeafSize(Node root){
        if(root == null){
            return ;
        }

        if(root.left == null && root.right == null){
            count++;
        }
        getLeafSize (root.left);
        getLeafSize (root.right);
    }

    public static void main(String[] args) {
        Node root = buildTree ();
        getLeafSize (root);
        System.out.println (count);
    }
}
