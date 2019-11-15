import java.util.Scanner;

public class Main {

    //有一个数组，当它元素个数不为0时，就持续按照以下规则删除，输出最后一个删除的数字
    //删除规则：0-->1-->2（删除）-->3-->4-->5（删除）-->6-->7（下个删除的是0）
    //思路：
    //转换为循环链表，先尾插完成链表的建立，随后进行删除
    //注意：
    //1.因为题目要求不断接收键盘输入且给出结果，所以使用全局变量定义空链表不可取
    //2.尾插时先记录最后一个结点，每次都遍历寻找最后一个结点时间复杂度过高

    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }

        public String toString(){
            return String.format ("%d",val);
        }
    }

    //public static Node head = null;
    //public static int size = 0;

    //尾插并转换为循环链表
    public static Node insert(Node head,int n){
        Node last = null;
        for(int i = 0 ;i < n;i++) {
            Node node = new Node (i);

            if (head == null) {
                head = node;
            } else {
                last.next = node;
            }
            last = node;
        }
        last.next = head;
        return head;
    }

    //循环链表
    /*public static void CirculLinkedList(Node head){
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = head;
    }*/

    public static int deleteArray(Node head,int size){
        Node cur = head;
        while(size != 1){
            cur = cur.next;//找到要删除的结点的前驱
            //Node de = cur.next.next;
            cur.next = cur.next.next;//删除结点
            cur = cur.next;//更新cur的位置
            size--;
        }
        return cur.val;

    }

    public static void main(String[] args) {
        Node head = null;
        int size = 0;
        Scanner sc = new Scanner (System.in);
        while(sc.hasNext ()) {
            int n = sc.nextInt ();
            Node res = insert (head,n);
            System.out.println (deleteArray (res,n));
        }


    }

}
