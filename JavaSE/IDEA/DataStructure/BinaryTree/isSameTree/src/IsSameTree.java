public class IsSameTree {

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
    public static boolean isSameTree(Node p,Node q){
         if(p == null && q == null){
             return true;
         }
         if(p == null || q == null){
             return false;
         }

         return p.val == q.val
                 && isSameTree(p.left,q.left)
                 && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        Node p = buildTree ();
        Node q = buildTree ();
        System.out.println (isSameTree(p,q));
    }
}
