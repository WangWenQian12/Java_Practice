public class IsMirrorTree {


    //判断俩颗树是否为镜像对称的树

    private static class Node{
        int val;
        Node left = null;
        Node right = null;
        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
        }
    }

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

    public static boolean isMirrorTree(Node p,Node q){
            if(p == null && q == null){
                return true;
            }
            if(p == null || q == null){
                return false;
            }
            return p.val == q.val
                    &&isMirrorTree (p.left,q.right)
                    &&isMirrorTree (p.right,q.left);
    }


    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        System.out.println (isMirrorTree (root,root));

    }
}
