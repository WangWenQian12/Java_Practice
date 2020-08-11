import java.util.*;

public class Solution {

    // 包含min函数的栈
    // 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数

    ArrayList<Integer> stack = new ArrayList<> ();
    ArrayList<Integer> minstack = new ArrayList<> ();

    public void push(int node) {
        stack.add (node);
        if(minstack.isEmpty ()){
            minstack.add (node);
        }else if(node <= minstack.get (minstack.size ()-1)){
            minstack.add (node);
        }else{
            minstack.add (minstack.get (minstack.size ()-1));
        }
    }

    public void pop() {
        stack.remove (stack.size ()-1);
        minstack.remove (minstack.size ()-1);
    }

    public int top() {
        return stack.get (stack.size ()-1);
    }

    public int min() {
        return minstack.get (minstack.size ()-1);
    }
}