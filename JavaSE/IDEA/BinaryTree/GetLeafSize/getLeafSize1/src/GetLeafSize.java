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

    //汇总的思路
    public static int getLeafSize(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){//没有左右孩子，必为叶子结点
            return 1;
        }

        int left = getLeafSize(root.left);
        int right = getLeafSize(root.right);

        return left+right;
    }

    public static void main(String[] args) {
        Node root = buildTree ();
        System.out.println (getLeafSize(root));
    }
}
