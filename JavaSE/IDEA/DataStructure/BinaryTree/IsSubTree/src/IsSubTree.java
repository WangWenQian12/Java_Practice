public class IsSubTree {

    //给出俩颗树，判断t是否为s的子树

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

    //俩颗树都不为空
    public static boolean isSubTree(Node s,Node t){
        if(isSameTree(s,t)){
            return true;
        }
        if(isSameTree(s.left,t)){
            return true;
        }

        return isSameTree(s.right,t);
    }



    public static void main(String[] args) {
        Node s1 = new Node('A');
        Node s2 = new Node('B');
        Node s3 = new Node('C');
        Node s4 = new Node('D');
        Node s5 = new Node('E');
        Node s6 = new Node('F');
        Node s7 = new Node('G');
        Node s8 = new Node('H');
        s1.left= s2;
        s1.right = s3;
        s2.left = s4;
        s2.right = s5;
        s3.left = s6;
        s3.right = s7;
        s5.right = s8;

        System.out.println (isSubTree(s1,s2));


    }
}
