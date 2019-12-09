import java.util.LinkedList;
import java.util.Queue;

public class LevelTravel {

    //二叉树的层序遍历
    //思路：
    //1.将根结点入队列
    //2.队列不为空时.将根节点出队列，如果根有左右孩子时，将跟的左右孩子入队列
    //3.直到队列为空，结束遍历


    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format ("{%c}",val);
        }
    }

    public static void levelTravel(Node root){
        if(root == null){
            return ;
        }

        Queue<Node> queue = new LinkedList ();
        queue.offer(root);//根入队列
        while(!(queue.isEmpty())){//注意是要判断整个队列是否为空
            Node front = queue.poll();//队首元素出队列
            System.out.println (front);
            if(front.left != null){
                queue.offer (front.left);//左孩子入队列
            }
            if(front.right != null){
                queue.offer (front.right);//右孩子入队列
            }
        }

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

        levelTravel (a);
    }
}
