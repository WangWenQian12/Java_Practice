import java.util.Arrays;
import java.util.Scanner;

public class BuildTreeUsePre {

    //仅利用前序遍历还原二叉树（左右子树空时用#表示）
    //再将此二叉树中序遍历的数组打印出来

    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
        }
    }

    //返回值类
    private static class Return{
        Node node;
        int used;

        Return(Node node,int used){
            this.node = node;
            this.used = used;
        }

        @Override
        public String toString() {
            System.out.println (node);
            return String.format("%d",used);
        }
    }

    //我们只知道前序遍历，但是为空的子树用#表示，我们可以通过使用了几个结点来区别左右子树
    public static Return buildTree(char[] prev){
        if(prev.length == 0){
            return new Return(null,0);
        }
        if(prev[0] == '#'){
            return new Return(null,1);
        }

        Node root = new Node(prev[0]);
        Return left = buildTree (Arrays.copyOfRange (prev,1,prev.length));
        Return right = buildTree (Arrays.copyOfRange (prev,1+left.used,prev.length));

        root.left = left.node;
        root.right = right.node;

        return new Return(root,1+left.used+right.used);
    }

    //输出中序遍历
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder (root.left);
        System.out.println (root);
        inorder (root.right);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String line = input.nextLine();
        char[] arr = line.toCharArray ();
        System.out.println (buildTree (arr));
        System.out.println ();
        inorder (buildTree (arr).node);
    }
}
