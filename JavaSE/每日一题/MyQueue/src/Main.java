import java.util.Stack;

class Queue {

    //用两个栈实现队列

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<> ();

    public void push(int node) {
        stack1.add (node);
    }

    public int pop() {
        if(stack2.isEmpty ()){
            int size = stack1.size ();
            for(int i = 0;i < size  ;i++){
                //将stack1中的栈顶元素入stack2中
                stack2.add(stack1.remove (stack1.size ()-1));
            }
        }
        return stack2.remove (stack2.size ()-1);
    }

}

public class Main{
    public static void main(String[] args) {
        Queue queue = new Queue ();
        queue.push (1);
        queue.push (2);
        queue.push (3);
        queue.pop ();
        queue.pop ();
        queue.push (4);
        queue.pop ();
        queue.push (5);
        queue.pop ();
        System.out.println ();
    }
}