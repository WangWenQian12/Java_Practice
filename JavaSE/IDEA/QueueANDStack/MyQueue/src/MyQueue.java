import java.util.ArrayList;


public class MyQueue {

    //使用栈实现队列的下列操作：
    //push(x) -- 将一个元素放入队列的尾部。
    //pop() -- 从队列首部移除元素。
    //peek() -- 返回队列首部的元素。
    //empty() -- 返回队列是否为空。

    //思路：
    //1.用俩个栈，一个用来入队列，一个用来出队列

    private ArrayList<Integer> in;
    private ArrayList<Integer> out;

    public MyQueue(){
        in = new ArrayList();
        out = new ArrayList();
    }

    //入队列
    public void push(int x){
        in.add(x);
    }

    //出队列
    public int pop(){
        if(out.isEmpty()) {
            int size = in.size();
            for (int i = 0; i < size; i++) {
                int v = in.remove(in.size()-1);
                out.add(v);
            }
        }
        return out.remove(out.size()-1);
    }

    //返回队列首部元素
    public int peek(){
        if(out.isEmpty()){
            int size = in.size();
            for(int i=0;i<size;i++){
                int v = in.remove(in.size()-1);
                out.add(v);
            }
        }
        return out.get(out.size()-1);
    }

    public boolean empty(){
        return in.isEmpty()&&out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue  = new MyQueue();
        queue.push(3);
        queue.push(2);
        queue.push(1);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        if(queue.empty()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

}
