import java.util.LinkedList;

public class MyStack {
    //使用队列实现栈的下列操作：
    //	push(x) -- 元素 x 入栈
    //	pop() -- 移除栈顶元素
    //	top() -- 获取栈顶元素
    //	empty() -- 返回栈是否为空

    private LinkedList<Integer> queue;

    public MyStack(){
        queue = new LinkedList<>();
    }

    public void push(int x){
        queue.addLast(x);
    }

    public int pop(){
        int size = queue.size();
        for(int i=0;i<size-1;i++){
            int v = queue.pollFirst();
            queue.addLast(v);
        }
        return queue.pollFirst();
    }

    public int top(){
        int size = queue.size();
        for(int i=0;i<size-1;i++){
            int v = queue.pollFirst();
            queue.addLast(v);
        }
        int v = queue.pollFirst();
        queue.addLast(v);
        return v;
    }

    public boolean empty(){
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        if(stack.empty()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }
}
