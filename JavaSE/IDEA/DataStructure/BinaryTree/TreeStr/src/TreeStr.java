public class TreeStr {

    //采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%d}",val);
        }
    }

    //左右子树都为空时，不用写括号；左子树空右子树非空，写一个括号；左子树不为空，右子树为空，右子树的括号省略
    public static String _treeStr(Node t){
        String s = "";//创造一个空串
        if(t!=null) {
            s += '(';
            s += t.val;
            if (t.left == null && t.right == null){

            }else if(t.left != null && t.right == null){
                s += _treeStr (t.left);
            }else if(t.left == null && t.right != null){
                s += "()";
                s += _treeStr (t.right);
            }else{
                s += _treeStr (t.left);
                s += _treeStr (t.right);
            }
            s += ')';
        }
        return s;
    }

    public static String treestr(Node t){
        if(t == null){
            return null;
        }
        String str = _treeStr (t);
        return str.substring (1,str.length()-1);
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;

        System.out.println (treestr (a));


    }
}
