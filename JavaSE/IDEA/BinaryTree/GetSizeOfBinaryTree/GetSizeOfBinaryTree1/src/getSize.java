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

    //计算出二叉树的结点个数
    //1.遍历的思路
    //记录的位置一定要独立于遍历过程之外
    //每次统计之前都要将count置0
    private static int count = 0;
    public static void getSize(Node root){
        if(root == null){
            return;
        }

        count++;
        getSize(root.left);
        getSize(root.right);

    }


    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        getSize(root);
        System.out.println (count);
    }
}
