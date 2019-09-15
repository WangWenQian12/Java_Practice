public class getSize {

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
        b.right = e;
        c.left = f;
        c.right = g;
        e.right = h;

        return a;
    }


    //汇总的思路
    //根+左子树结点个数+右子树节点个数
    public static int getSize(Node root){
        if(root == null){
            return 0;
        }
        int left = getSize(root.left);
        int right = getSize(root.right);
        return left+right+1;
    }

    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        System.out.println (getSize(root));
    }
}
