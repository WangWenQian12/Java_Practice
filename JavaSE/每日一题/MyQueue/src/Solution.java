import java.util.Stack;

public class Solution {

    //用两个栈实现队列

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add (node);
    }

    public int pop() {
        if(stack2.isEmpty ()){
            int size = stack1.size ();
            for(int i = 0;i < size ;i++){
                //将stack1中的栈顶元素入stack2中
                stack2.add(stack1.remove (stack1.size ()-1));
            }
        }
        return stack2.remove (stack2.size ()-1);
    }
}