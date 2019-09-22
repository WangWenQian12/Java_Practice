public class IsBalanceTree {

    //判断是否为平衡二叉树

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
        //b.right = e;
        c.left = f;
        c.right = g;
        //e.right = h;
        d.left = h;

        return a;
    }

    public static int getLength(Node root){
        if(root == null){
            return 0;
        }

        int left = getLength(root.left);
        int right = getLength(root.right);
        return Math.max(left,right)+1;
    }

    public static boolean isBalancedTree(Node root){
        if(root == null){
            return true;
        }
        if(!(isBalancedTree (root.left))){
            return false;
        }
        if(!(isBalancedTree (root.right))){
            return false;
        }

        int left = getLength(root.left);
        int right = getLength(root.right);
        int dif = left - right;
        if(dif<=1 && dif >=-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        System.out.println (isBalancedTree (root));
    }
}
