public class GeHeight {


    //求二叉树的高度

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

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        Node root = buildTree ();
        System.out.println (getHeight (root));
    }
}
