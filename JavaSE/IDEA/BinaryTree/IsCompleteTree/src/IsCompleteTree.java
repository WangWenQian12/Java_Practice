import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

    //传入层序遍历的结果，判断这棵二叉树是否为平衡二叉树

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

    public static boolean isBalanced(Node root){
        if(root == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<> ();
        queue.offer(root);

        while(true){
            Node front = queue.poll();
            if(front == null){//检测到有null出现时，跳出
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);

        }

        //检查队列中是否为空，如果为空，说明在上述出栈时碰到的null是最新一层的
        //如果不为空，则要判断剩下的队列中是是否还有不为null的结点，如果有，说明不是完全二叉树
        while(!(queue.isEmpty())){
            Node front = queue.poll();
            if(front != null){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
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

        System.out.println (isBalanced(a));
    }
}
