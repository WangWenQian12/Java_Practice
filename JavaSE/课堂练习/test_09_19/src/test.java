import java.util.*;

public class test {

    //层序遍历

    private static class Node{
        char val;
        Node left;
        Node right;
        Node(char val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
        }
    }

    //只给前序遍历得到二叉树
    public static Node buildTree1(char[] pre){
        if(pre.length == 0){
            return null;
        }
        if(pre[0] == '#'){

        }
        Node root = new Node(pre[0]);
        int used = 0;


    }


    //由先序遍历得到源二叉树（以指针方式存储），再写出二叉树的中序遍历

    //返回值类
    private static class AB{
        private Node root;
        private int used;
        private AB(Node root,int used) {
            this.root = root;
            this.used = used;
        }
    }

    //还原二叉树
    public static AB buildTree(char[] prev){
        //A returnValue = new A();
        if(prev.length == 0){
            return new AB(null,0);
        }

        //如果第一个为#，那树为空，使用一个结点
        if(prev[0]=='#'){
            return new AB(null,1);
        }

        Node root = new Node(prev[0]);
        AB left = buildTree(Arrays.copyOfRange (prev,1,prev.length));
        AB right = buildTree(Arrays.copyOfRange (prev,1+left.used,prev.length));

        root.left = left.root;
        root.right = right.root;

        return new AB(root,1+left.used+right.used);

    }

    //输出中序遍历
    public static void inorder(Node root){
        if(root == null){
            return ;
        }
        inorder (root.left);
        System.out.print (root+" ");
        inorder (root.right);

    }


    //二叉树的层序遍历（重点）
    public static void levelTravlesal(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);//根入队列
        if(!(queue.isEmpty())){
            Node front = queue.poll();//找出队列中的第一个元素,出队列
            System.out.println (front);
            if(front.left != null){
                queue.offer(front.left);//左孩子入队列
            }
            if(front.right != null){
                queue.offer(front.right);//右孩子入队列
            }

        }

    }

    //二叉树的层序遍历（输出时带着该结点的层数）
    private static class NodeLevel{
        Node node;
        int level;
        NodeLevel(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void levelTravel(Node root){
        if(root == null){
            return;
        }
        Queue<NodeLevel> queue  = new LinkedList<> ();
        queue.offer (new NodeLevel (root,0));
        while(!(queue.isEmpty ())){
            NodeLevel front = queue.poll();
            System.out.println (front.level+" : "+front.node);
            if(front.node.left != null){
                queue.offer(new NodeLevel(front.node.left,front.level+1));
            }
            if(front.node.right != null){
                queue.offer(new NodeLevel(front.node.right,front.level+1));
            }
        }
    }

    //二叉树的层序遍历并分层输出
    //public static void



    //判断二叉树是否为完全二叉树（传入层序遍历的数组，空用#表示）
    public static Node BuildTree(char[] arr){

    }

    public static boolean isCompleteTree(Node root){}



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        char[] array = line.toCharArray();
        AB a = buildTree (array);
        inorder (a.root);

    }
}
