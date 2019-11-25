public class findNode {

    //查找二叉树中值为val的结点

    private static class Node {
        private int val;
        private Node left = null;
        private Node right = null;

        private Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%d}", val);
        }
    }

    public static Node buildTree() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }

    public static Node find(Node root,int val){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        Node m = find(root.left,val);
        if(m != null){
            return m;
        }

        Node n = find(root.right,val);
        if(n != null){
            return n;
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = buildTree ();
        System.out.println (find(root,5));
    }
}
