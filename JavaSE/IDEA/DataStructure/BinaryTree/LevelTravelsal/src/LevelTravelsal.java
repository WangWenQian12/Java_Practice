import java.util.LinkedList;
import java.util.Queue;

public class LevelTravelsal {

    //层序遍历二叉树，并输出时第几层

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

    private static  class NodeLevel{
        Node node;
        int level;

        NodeLevel(Node node,int level){
            this.node = node;
            this.level = level;
        }

    }

    public static void levelTravel(Node root){
        if(root == null){
            return ;
        }

        Queue<NodeLevel> queue = new LinkedList<> ();
        queue.offer (new NodeLevel(root,0));
        while(!(queue.isEmpty ())){
            NodeLevel front = queue.poll();//队首元素出队列
            System.out.println (front.node+" : "+front.level);
            if(front.node.left != null){
                queue.offer(new NodeLevel(front.node.left,front.level+1));//左子树入队列
            }
            if(front.node.right != null){
                queue.offer(new NodeLevel(front.node.right,front.level+1));//右子树入队列
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
