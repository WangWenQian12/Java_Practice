
   class Node{
       int val;
       Node next = null;

       Node(int val){
           this.val= val;
           this.next = null;
       }
   }

   public class MyLinkedList{

       //头插
       public static Node pushFront(Node head,int val){
           Node node = new Node(val);
           node.next = head;
           return node;
       }

       //尾插
       public static Node pushBack(Node head,int val){
           Node node = new Node(val);
           if(head==null){
               return node;
           }
           else{
               Node last = head;
               while(last.next!=null){
                   last = last.next;
               }
               last.next = node;
               return head;
           }
       }

       //头删
       public static Node popFront(Node head){
           if(head==null){
               System.err.println("error!");
               return null;
           }
           return head.next;
       }

       //尾删
       public static Node popBack(Node head){
           if(head == null){
               System.err.println("error!");
               return null;
           }
           else{
               Node last2 = head;
               while(last2.next.next != null){
                   last2 = last2.next;
               }
               last2.next = null;
               return head;
           }

       }

       //打印
       public static void print(Node head){
           Node cur = head;
           while(cur != null){
               System.out.print(cur.val + "-->");
               cur = cur.next;
           }
           System.out.print("null");
           System.out.println();
       }


       public static  void main(String[] args){
           Node head = null;
           head = pushFront(head,3);
           head = pushFront(head,2);
           head = pushFront(head,1);
           print(head);//3 2 1
           head = pushBack(head,4);
           head = pushBack(head,5);
           print(head);//1 2 3 4  5
           head = popFront(head);
           print(head);//2 3 4 5
           head = popBack(head);
           print(head);//2 3 4
       }
   }


























