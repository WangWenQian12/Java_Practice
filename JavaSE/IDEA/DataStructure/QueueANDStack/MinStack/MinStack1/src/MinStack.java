import java.util.ArrayList;

public class MinStack {

    //设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    //	push(x) -- 将元素 x 推入栈中。
    //	pop() -- 删除栈顶的元素。
    //	top() -- 获取栈顶元素。
    //	getMin() -- 检索栈中的最小元素。

    private ArrayList<Integer> normal;
    private ArrayList<Integer> min;

    public MinStack(){
        normal = new ArrayList<>();
        min = new ArrayList<>();
    }

    public void push(int x){
        normal.add (x);
        if(min.isEmpty()){
            min.add(x);
        }
        if(x <= min.get(min.size()-1)){
            min.add(x);
        }
    }

    public void pop(){
        int v = normal.remove(normal.size()-1);
        if(v == min.get(min.size()-1)){
            min.remove(min.size()-1);
        }
    }

    public int top(){
        return normal.get(normal.size()-1);
    }

    public int getMin(){
        return min.get(min.size()-1);
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(8);
        stack.push(7);
        stack.push(1);
        stack.push(9);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}


