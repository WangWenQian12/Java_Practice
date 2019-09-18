public class IsSymmetric {

    //判断一棵树是否为对称二叉树

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
        Node c = new Node('B');
        Node d = new Node('C');
        Node e = new Node('C');
        Node f = new Node('D');
        Node g = new Node('D');
        Node h = new Node('E');
        Node i = new Node('E');
        a.left= b;
        a.right = c;
        b.left = d;
        b.right = f;
        c.left = g;
        c.right = e;
        f.left = h;
        g.right = i;

        return a;
    }


    //判断是否为镜像二叉树
    public static boolean isMirrorTree(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val
                &&isMirrorTree(p.left,q.right)
                &&isMirrorTree (p.right,q.left);
    }

    //判断是否为对称二叉树
    //实则为判断root的左右子树是否为镜像二叉树
    public static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }

        return isMirrorTree(root.left,root.right);
    }

    public static void main(String[] args) {
        Node root = buildBinaryTree ();
        System.out.println (isSymmetric (root));
    }
}
